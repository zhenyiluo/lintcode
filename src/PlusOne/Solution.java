public class Solution {
    /**
     * @param digits a number represented as an array of digits
     * @return the result
     */
    public int[] plusOne(int[] digits) {
        // Write your code here
        if(digits == null || digits.length == 0){
            return new int[0];
        }
        int len = digits.length;
        int[] ret = new int[len];
        
        int carryOver = 1;
        int sum = 0;
        for(int i = len-1; i>=0; i--){
            sum = carryOver + digits[i];
            if(sum == 10){
                sum = 0;
                carryOver = 1;
            }else{
                carryOver = 0;
            }
            ret[i] = sum;
        }
        
        if(carryOver == 1){
            int[] tmp = new int[len+1];
            tmp[0] = 1;
            for(int i = 0; i < len; i++){
                tmp[i+1] = ret[i];
            }
            ret = tmp;
        }
        return ret;
    }
}
