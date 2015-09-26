public class Solution {
    /**
     * @param nums: an array of integers
     * @return: return nothing (void), do not return anything, modify nums in-place instead
     */
    public void nextPermutation(int[] nums) {
        // write your code here
        if(nums == null || nums.length <= 1){
            return;
        }
        
        int n = nums.length;
        int t = findFirstHigh(nums);
        if(t == 0){
            revert(nums, 0, nums.length -1);
        }else{
            int s = nums.length -1;
            while(nums[s] <= nums[t-1]){
                s --;
            }
            swap(nums, t-1, s);
            revert(nums, t, nums.length -1);
        }
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
    public void revert(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start++, end--);
        }
    }
    
    public int findFirstHigh(int[] nums){
        for(int i = nums.length -1; i >= 1; i--){
            if(nums[i] > nums[i-1]){
                return i;
            }
        }
        return 0;
    }
}
