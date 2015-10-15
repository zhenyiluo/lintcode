public class Solution {
    /**
     * @param s: A string
     * @return: A list of lists of string
     */
     boolean[][] dp;
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> ret = new ArrayList<>();
        if(s == null || s.length() == 0){
            return ret;
        }
        
        int len = s.length();
        dp  = new boolean[len][len];
        for(int i = len -1; i >= 0; i--){
            for(int j = i; j < len; j++){
                if(s.charAt(i) == s.charAt(j) && ((j - i < 2)||(dp[i+1][j-1]))){
                    dp[i][j] = true;
                }
            }
        }
        
        return dfs(s, 0);
    }
    
    private List<List<String>> dfs(String s, int start){
        List<List<String>> ret = new ArrayList<>();
        if(start == s.length()){
            ret.add(new ArrayList<String>());
            return ret;
        }
        
        for(int i = start; i < s.length(); i++){
            if(dp[start][i]){
                for(List<String> list : dfs(s, i+1)){
                    list.add(0, s.substring(start, i+1));
                    ret.add(list);
                }
            }
        }
        return ret;
    }
}
