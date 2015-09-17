public class Solution {
    /**
     * @param path the original path
     * @return the simplified path
     */
    public String simplifyPath(String path) {
        // Write your code here
        String[] s = path.split("/");
        Stack<String> st = new Stack<String>();
        for(int i = 0; i < s.length; i++){
            String tmp = s[i];
            if(tmp.length() > 0){
                if(tmp.equals(".")){
                    continue;
                }else if(tmp.equals("..")){
                    if(!st.isEmpty()){
                        st.pop();
                    }
                }else{
                    st.push(tmp);
                }
            }
        }
        StringBuilder ret = new StringBuilder("");
        if(st.isEmpty()){
            ret.append("/");
        }else{
            while(!st.isEmpty()){
                ret.insert(0, "/" + st.pop());
            }
        }
        return ret.toString();
    }
}
