public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if(S == null || T == null || S.length() < T.length()){
            return 0;
        }
        int m = S.length();
        int n = T.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++){
            dp[i][0] = 1;
        }
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                dp[i][j] = dp[i-1][j];
                if(S.charAt(i-1) == T.charAt(j-1)){
                    dp[i][j] += dp[i-1][j-1];
                }
            }
        }
        return dp[m][n];
    }
}


// Optimize memory to O(n)

public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        if(S == null || T == null || S.length() < T.length()){
            return 0;
        }
        int m = S.length();
        int n = T.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1; i <= m; i++){
            for(int j = n; j >= 1; j--){
                if(S.charAt(i-1) == T.charAt(j-1)){
                    dp[j] += dp[j-1];
                }
            }
        }
        return dp[n];
    }
}
