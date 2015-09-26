public class Solution {
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values == null || values.length <= 2){
            return true;
        }
        int n = values.length;
        int[] dp = new int[n];
        dp[n-1] = values[n-1];
        dp[n-2] = values[n-2] + values[n-1];
        for(int i = n-3; i>= 0; i--){
            dp[i] = Math.max(values[i] - dp[i+1], values[i] + values[i+1] - dp[i+2]);
        }
        return dp[0] > 0;
    }
}
