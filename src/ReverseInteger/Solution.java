public class Solution {
    /**
     * @param n the integer to be reversed
     * @return the reversed integer
     */
    public int reverseInteger(int n) {
        // Write your code here
        long val = 0;
        while(n != 0){
            val = val * 10 + n % 10;
            n = n / 10;
        }
        if(val > Integer.MAX_VALUE || val < Integer.MIN_VALUE){
            return 0;
        }
        
        return (int) val;
    }
}
