public class Solution {
    /**
     * @param s A string
     * @return Whether the string is a valid palindrome
     */
    public boolean isPalindrome(String s) {
        // Write your code here
        if(s == null){
            return false;
        }
        s = s.trim();
        if(s.length() == 0){
            return true;
        }
        s = s.toLowerCase();
        
        int left = 0;
        int right = s.length() -1;
        while(left < right){
            while(left < s.length() && !isAlphanumeric(s.charAt(left))){
                left ++;
            }
            while(right >= 0 && left < right && !isAlphanumeric(s.charAt(right))){
                right --;
            }
            if(left < right){
                if(s.charAt(left) != s.charAt(right)){
                    return false;
                }
                left ++;
                right --;
            }
        }
        return true;
    }
    
    public boolean isAlphanumeric(char c){
        if((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')){
            return true;
        }
        return false;
    }
}
