public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m][n];
        sum[0][0] = matrix[0][0];
        for(int i = 1; i < m; i++){
            sum[i][0] = sum[i-1][0] + matrix[i][0];
        }
        
        for(int i = 1; i < n; i++){
            sum[0][i] = sum[0][i-1] + matrix[0][i];
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                sum[i][j] = matrix[i][j] + sum[i-1][j] + sum[i][j-1] 
                -sum[i-1][j-1];
            }
        }
    }
}
