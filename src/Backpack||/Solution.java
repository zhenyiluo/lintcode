public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A & V: Given n items with size A[i] and value V[i]
     * @return: The maximum value
     */
    public int backPackII(int m, int[] A, int V[]) {
        // write your code here
        int n = A.length;
        int[][] dp = new int[2][m+1];
        for(int i = 1; i <= n; i++){
            for(int j = 0; j <= m; j++){
                dp[1][j] = dp[0][j];
                if(j - A[i-1] >= 0){
                   dp[1][j] = Math.max(dp[1][j], dp[0][j - A[i-1]] + V[i-1]); 
                }
            }
            for(int j = 0; j <=m; j++){
               dp[0][j] = dp[1][j]; 
            }
        }
        return dp[1][m];
    }
}
