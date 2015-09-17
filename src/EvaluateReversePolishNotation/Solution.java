public class Solution {
    /**
     * @param tokens The Reverse Polish Notation
     * @return the value
     */
    public int evalRPN(String[] tokens) {
        // Write your code here
        if(tokens == null || tokens.length == 0){
            return 0;
        }
        Stack<Integer> st = new Stack<Integer>();
        int len = tokens.length;
        for(int i = 0; i < len; i++){
            String s = tokens[i];
            switch(s){
                case "+" : int val2 = st.pop();
                            int val1 = st.pop();
                            st.push(val1 + val2);
                            break;
                case "-" : val2 = st.pop();
                           val1 = st.pop();
                            st.push(val1 - val2);
                            break;
                case "*" : val2 = st.pop();
                           val1 = st.pop();
                            st.push(val1 * val2);
                            break;
                case "/" : val2 = st.pop();
                           val1 = st.pop();
                            st.push(val1 / val2);
                            break;
                default  : st.push(new Integer(s));
            }
        }
        return st.peek();
    }
    
    
}
