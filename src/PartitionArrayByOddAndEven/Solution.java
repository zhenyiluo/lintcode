public class Solution {
    /**
     * @param nums: an array of integers
     * @return: nothing
     */
    public void partitionArray(int[] nums) {
        // write your code here;
        if(nums == null || nums.length == 0){
            return;
        }
        
        int index = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 1){
                swap(nums, index++, i);
            }
        }
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
