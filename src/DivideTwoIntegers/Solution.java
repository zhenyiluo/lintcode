public class Solution {
    /**
     * @param dividend the dividend
     * @param divisor the divisor
     * @return the result
     */
    public int divide(int dividend, int divisor) {
        // Write your code here
        if(divisor == 0){
            return Integer.MAX_VALUE;
        }
        
        long d1 = dividend;
        long d2 = divisor;
        int count = 0;
        if(d1 < 0){
            count ++;
            d1 = -d1;            
        }
        
        if(d2 < 0){
            count ++;
            d2 = -d2;
        }
        long ret = 0;
        while(d1 >= d2){
            int shift = 0;
            while(d1 >= (d2 << shift)){
                shift ++;
            }
            d1 -= d2 << (shift-1);
            ret += (long)1 << (shift-1);
        }
        if(count % 2 == 1){
            ret = -ret;
        }
        
        if(ret < Integer.MIN_VALUE || ret > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }
        
        return (int)ret;
    }
}
