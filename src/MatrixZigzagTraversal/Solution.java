public class Solution {
    /**
     * @param matrix: a matrix of integers
     * @return: an array of integers
     */ 
    public int[] printZMatrix(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[] ret = new int[m * n];
        int index = 0;
        int max = m + n -2;
        for(int i = 0; i <= max; i++){
            for(int j = 0; j <= i; j++){
                int x = i-j;
                int y = j;
                if(i % 2 != 0){
                    x = j;
                    y = i-j;
                }
                if(x >= 0 && y >= 0 && x < m && y < n){
                    ret[index++] = matrix[x][y];
                }
            }
        }
        return ret;
    }
}
