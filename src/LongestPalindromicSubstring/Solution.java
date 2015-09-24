public class Solution {
    
    /**
     * @param s input string
     * @return the longest palindromic substring
     */
    public String longestPalindrome(String s) {
        // Write your code here
        if(s == null || s.length() == 0){
            return "";
        }
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        
        for(int i = n-1; i >= 0; i--){
            for(int j = i; j < n; j++){
                if(s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i+1][j-1])){
                    dp[i][j] = true;
                }
            }
        }
        
        int max = 0;
        String ret = "";
        for(int i = 0; i < n; i++){
            for(int j = i; j< n; j++){
                if(j-i+1 > max && dp[i][j]){
                    max = j-i+1;
                    ret = s.substring(i, j+1);
                }
            }
        }
        return ret;
    }
}
