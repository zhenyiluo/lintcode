public class Solution {
    /**    
     * @param nums: an array of integers
     * @return: an integer
     */
    public int findMissing(int[] nums) {
        // write your code here
        int n = nums.length;
        int target = n * (n+1) /2;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        return target - sum;
    }
}
