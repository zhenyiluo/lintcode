public class Solution {
    /**
     * @param s A string
     * @return whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        // Write your code here
        if(s == null || s.length() == 0){
            return true;
        }
        int len = s.length();
        if(len % 2 != 0){
            return false;
        }
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < len; i++){
            char c = s.charAt(i);
            switch(c){
                case '(' : 
                case '{' :
                case '[' : st.push(c); break;
                case '}' : if(st.isEmpty() || st.pop() != '{'){
                    return false;
                }
                break;
                case ']' : if(st.isEmpty() || st.pop() != '['){
                    return false;
                }
                break;
                case ')' : if(st.isEmpty() || st.pop() != '('){
                    return false;
                }
                break;
            }
        }
        return st.isEmpty();
    }
}
