public class Solution {
    /**
     *@param n: Given a decimal number that is passed in as a string
     *@return: A string
     */
     static final double eps = 1e-6;
    public String binaryRepresentation(String n) {
        // write your code here
        String[] s = n.split("\\.");
        StringBuilder sb = new StringBuilder();
        double d = Double.valueOf("0." + s[1]);
        boolean flag = false;
        for(int i = 0; i < 32; i++){
            d *= 2;
            if(Math.abs(d) < eps){
                flag = true;
                break;
            }else if(d >= 1){
               d -= 1; 
               sb.append(1);
            }else{
               sb.append(0);
            }
        }
        if(!flag){
            return "ERROR";
        }
        boolean sign = true;
        int num = Integer.valueOf(s[0]);
        if(num < 0){
            sign = false;
            num = -num;
        }
        StringBuilder sb1 = new StringBuilder();
        while(num > 0){
            if(num % 2 == 0){
                sb1.insert(0, 0);
            }else{
                sb1.insert(0, 1);
            }
            num /= 2;
        }
        StringBuilder ret = new StringBuilder();
        if(!sign){
            ret.append("-");
        }
        ret.append(sb1.toString());
        if(sb.length() > 0){
            if(ret.length() == 0){
                ret.append("0");
            }
            ret.append("." + sb.toString());
        }
        
        if(ret.length() == 0){
            ret.append('0');
        }
        return ret.toString();
    }
}
