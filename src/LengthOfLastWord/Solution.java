public class Solution {
    /**
     * @param s A string
     * @return the length of last word
     */
    public int lengthOfLastWord(String s) {
        // Write your code here
        if(s == null){
            return 0;
        }
        s = s.trim();
        if(s.length() == 0){
            return 0;
        }
        int len = s.length();
        int ret = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == ' '){
                ret = 0;
            }else{
                ret ++;
            }
        }
        return ret;
    }
}
