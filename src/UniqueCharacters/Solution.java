public class Solution {
    /**
     * @param str: a string
     * @return: a boolean
     */
    public boolean isUnique(String str) {
        // write your code here
        if(str == null){
            return false;
        }
        
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        for(int i = 1; i < str.length(); i++){
            if(chars[i] == chars[i-1]){
                return false;
            }
        }
        return true;
    }
}
