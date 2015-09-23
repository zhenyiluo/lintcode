public class Solution {
    /**
     * @param s the string that represents a number
     * @return whether the string is a valid number
     */
    public boolean isNumber(String s) {
        // Write your code here
        if(s == null){
            return false;
        }
        s = s.trim();
        if(s.length() == 0){
            return false;
        }
        int countE = 0;
        int countDot = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' '){
                return false;
            }else if(c == '.'){
                if(i == s.length() -1){
                    return false;
                }
                countDot++;
            }else if(c == 'e'){
                if(i == 0 || i == s.length() -1){
                    return false;
                }
                countE++;
            }else if(c < '0' || c > '9'){
                return false;
            }else if(c == '+' || c == '-'){
                if(i != 0 && s.charAt(i-1) != 'e'){
                    return false;
                }
            }
        }
        if(countDot > 1 || countE > 1){
            return false;
        }
        return true;
    }
}
