public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        
        int n = matrix.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                swap(matrix, i, j, j, i);
            }
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n/2; j++){
                swap(matrix, i, j, i, n -j -1);
            }
        }
    }
    
    private void swap(int[][] matrix, int x1, int y1, int x2, int y2){
        int tmp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tmp;
    }
}


public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @return: Void
     */
    public void rotate(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return;
        }
        
        int n = matrix.length;
        
        for(int i = 0; i < n / 2; i ++){
            for(int j = i; j < n - i - 1; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n - j -1] = matrix[j][n- i - 1];
                matrix[j][n- i - 1] = tmp;
            }
        }
    }
    
}
