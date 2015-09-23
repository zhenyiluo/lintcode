public class Solution {
    /**
     * @param n the nth
     * @return the nth sequence
     */
    public String countAndSay(int n) {
        // Write your code here
        if(n == 1){
            return "1";
        }
        String result = "1";
        for(int i = 2; i <= n; i++){
            result = convert(result);
        }
        return result;
    }
    
    private String convert(String result){
        StringBuilder ret = new StringBuilder();
        char prev = '-';
        int count = 0;
        for(int i = 0; i < result.length(); i++){
            char cur = result.charAt(i);
            if(cur == prev){
                count++;
            }else{
                if(count != 0){
                    ret.append("" + count + prev);
                }
                prev = cur;
                count = 1;
            }
        }
        ret.append("" + count + prev);
        return ret.toString();
    }
}
