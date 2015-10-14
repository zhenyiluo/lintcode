class Solution {
    /**
     * @param nums: A list of integer which is 0, 1 or 2 
     * @return: nothing
     */
    public void sortColors(int[] nums) {
        // write your code here
        if(nums == null || nums.length <= 1){
            return;
        }
        
        int start = 0;
        int end = nums.length -1;
        int index = 0;
        while(index <= end){
            if(nums[index] == 0){
                swap(nums, start++, index++);
            }else if(nums[index] == 2){
                swap(nums, index, end--);
            }else{
                index++;
            }
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
