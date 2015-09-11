// 2086 ms
public class Solution {
    /**
     * @param matrix: a matrix of 0 and 1
     * @return: an integer
     */
    public int maxSquare(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int[][] h = new int[m][n];
        int[][] v = new int[m][n];
        for(int i = 0; i < m; i++){
            if(matrix[i][0] == 1){
                dp[i][0] = 1;
                h[i][0] = 1;
            }
        }
        for(int j = 0; j < n; j++){
            if(matrix[0][j] == 1){
                dp[0][j] = 1;
                v[0][j] = 1;
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 1){
                    v[i][j] = v[i-1][j] + 1;
                }else{
                    v[i][j] = 0;
                }
            }
        }
        
        for(int j = 1; j < n; j++){
            for(int i = 0; i < m; i++){
                if(matrix[i][j] == 1){
                    h[i][j] = h[i][j-1] + 1;
                }else{
                    h[i][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(matrix[i][j] == 1){
                    int limit = Math.min(v[i][j], h[i][j]);
                    dp[i][j] = Math.min(limit, dp[i-1][j-1] + 1);
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
    }
}
