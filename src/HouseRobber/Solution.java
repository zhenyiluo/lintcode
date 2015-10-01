public class Solution {
    /**
     * @param A: An array of non-negative integers.
     * return: The maximum amount of money you can rob tonight
     */
    public long houseRobber(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        
        int len = A.length;
        if(len == 1){
            return A[0];
        }
        
        long[] dp = new long[len];
        dp[0] = A[0];
        dp[1] = Math.max(A[0], A[1]);
        for(int i = 2; i < len; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + A[i]);
        }
        return dp[len-1];
    }
}
