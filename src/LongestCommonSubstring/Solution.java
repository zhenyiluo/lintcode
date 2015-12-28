public class Solution {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A == null || B == null || A.length() == 0 || B.length() == 0){
            return 0;
        }
        int lenA = A.length();
        int lenB = B.length();
        int[][] dp = new int[lenA+1][lenB+1];
        for(int i = 0; i < lenA; i++){
            for(int j = 0; j < lenB; j++){
                if(A.charAt(i) == B.charAt(j)){
                    dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + 1);
                }
            }
        }
        int ret = 0;
        for(int i = 0; i < lenA; i++){
            for(int j = 0; j< lenB; j++){
                ret = Math.max(ret, dp[i+1][j+1]);
            }
        }
        return ret;
    }
}