public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        if(nums.length == 1){
            return nums[0];
        }
        int len = nums.length;
        int sum = 0;
        int min = 0;
        int ret = Integer.MIN_VALUE;
        
        for(int i = 0; i < len; i++){
            sum += nums[i];
            ret = Math.max(ret, sum - min);
            min = Math.min(min, sum);
        }
        return ret;
    }
}