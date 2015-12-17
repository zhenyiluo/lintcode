public class Solution {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if(nums == null || nums.length == 0){
	        return 0;
	    }
	    
	    int start = 0;
	    int end = nums.length - 1;
	    while(start <= end){
	        while(start <= end && nums[start] < k){
	            start ++;
	        }
	        while(start <= end && nums[end] >= k){
	            end --;
	        }
	        
	        if(start <= end){
	            int tmp = nums[start];
	            nums[start] = nums[end];
	            nums[end] = tmp;
	            start ++;
	            end --;
	        }
	    }
	    return start;
    }
}