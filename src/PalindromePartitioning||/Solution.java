public class Solution {
    /**
     * @param s a string
     * @return an integer
     */
    public int minCut(String s) {
        // write your code here
        if(s == null || s.length() == 0){
            return 0;
        }
        
        int[] minCut = new int[s.length() + 1];
        for(int i = 0; i < s.length(); i++){
            minCut[i] = s.length() - i;
        }
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i = s.length() -1; i >= 0; i--){
            for(int j = i; j < s.length(); j++){
                if(s.charAt(i) == s.charAt(j) && ((j -i < 2)||(dp[i+1][j-1]))){
                    dp[i][j] = true;
                    minCut[i] = Math.min(minCut[i], minCut[j+1] +1);
                }
            }
        }
        
        return minCut[0] -1;
    }
};
