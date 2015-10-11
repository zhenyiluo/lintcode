public class Solution {
    /**
     * @param nums: an array of integers
     * @return: an integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        if(nums == null || nums.length <1){
            return 0;
        }
        int len = nums.length;
        int min = nums[0];
        int max = nums[0];
        int ret = nums[0];
        for(int i = 1; i < nums.length; i++){
            int tmpMin = min;
            int val = nums[i];
            min = Math.min(val, Math.min(val * min, val *max));
            max = Math.max(val, Math.max(val * tmpMin, val *max));
            ret = Math.max(ret, max);
        }
        
        return ret;
    }
}
