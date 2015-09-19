class Solution {
    /**
     * @param nums: an array of integers
     * @return: the maximum difference
     */
    public int maximumGap(int[] nums) {
        if(nums == null || nums.length < 2){
            return 0;
        }
        // write your code here
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        if(max == min){
            return 0;
        }
        int len = nums.length;
        Bucket[] buckets = new Bucket[len + 1];
        for(int i = 0; i<= len; i++){
            buckets[i] = new Bucket();
        }
        double interval = 1.0 * len / (max - min);
        for(int i = 0; i < len; i++){
            int index = (int) ((nums[i] - min) * interval);
            if(buckets[index].min == -1){
                buckets[index].min = nums[i];
                buckets[index].max = nums[i];
            }else{
                buckets[index].min = Math.min(buckets[index].min, nums[i]);
                buckets[index].max = Math.max(buckets[index].max, nums[i]);
            }
        }
        
        int prev = buckets[0].max;
        int ret = 0;
        for(int i = 1; i <= len; i++){
            if(buckets[i].min != -1){
                ret = Math.max(ret, buckets[i].min - prev);
                prev = buckets[i].max;
            }
        }
        return ret;
    }
    
    public static class Bucket{
        public int min;
        public int max;
        public Bucket(){
            min = -1;
            max = -1;
        }
    }
}
