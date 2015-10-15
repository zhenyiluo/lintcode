public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
     String[] s = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> ret = new ArrayList<String>();
        if(digits == null || digits.length() == 0){
            return ret;
        }
        int len = digits.length();
        return dfs(digits, 0);
    }
    
    private ArrayList<String> dfs(String digits, int start){
        ArrayList<String> ret = new ArrayList<String>();
        if(start == digits.length()){
            ret.add("");
            return ret;
        }
        char c = digits.charAt(start);
        int index = c - '2';
        String tmp = s[index];
        ArrayList<String> list = dfs(digits, start+1);
        for(int i= 0; i < tmp.length(); i++){
            for(String str : list){
                 char cTmp = tmp.charAt(i);
                 ret.add(cTmp + str);
             }      
        }
        return ret;
    }
}


public class Solution {
    /**
     * @param digits A digital string
     * @return all posible letter combinations
     */
     String[] s = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    public ArrayList<String> letterCombinations(String digits) {
        // Write your code here
        ArrayList<String> ret = new ArrayList<String>();
        if(digits == null || digits.length() == 0){
            return ret;
        }
        ret.add("");
        int len = digits.length();
        
        for(int i= 0; i < digits.length(); i++){
            char c = digits.charAt(i);
            int index = c - '2';
            String tmp = s[index];
            ArrayList<String> list = ret;
            ret = new ArrayList<String>();
            for(String sTmp : list){
                for(int j = 0; j < tmp.length(); j++){
                    ret.add(sTmp + tmp.charAt(j));
                }
            }
        }
        
        return ret;
    }
}

