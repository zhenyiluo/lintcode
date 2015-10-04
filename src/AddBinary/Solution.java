public class Solution {
    /**
     * @param a a number
     * @param b a number
     * @return the result
     */
    public String addBinary(String a, String b) {
        // Write your code here
        StringBuilder sa = new StringBuilder(a);
        StringBuilder sb = new StringBuilder(b);
        sa.reverse();
        sb.reverse();
        StringBuilder ret = new StringBuilder();
        int len = Math.max(a.length(), b.length());
        int carryOver = 0;
        int sum;
        for(int i = 0; i < len; i++){
            sum = carryOver;
            if(i < a.length()){
                sum += sa.charAt(i) - '0';
            }
            if(i < b.length()){
                sum += sb.charAt(i) - '0';
            }
            
            if(sum >= 2){
                sum -= 2;
                carryOver = 1;
            }else{
                carryOver = 0;
            }
            
            ret.append(sum);
        }
        if(carryOver == 1){
            ret.append(1);
        }
        
        return ret.reverse().toString();
    }
}
