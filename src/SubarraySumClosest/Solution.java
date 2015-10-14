public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySumClosest(int[] nums) {
        // write your code here
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return ret;
        }
        
        int first = -1;
        int last = -1;
        int len = nums.length;
        long[] sum = new long[len+1];
        sum[0] = 0;
        for(int i = 0; i < len; i++){
            sum[i+1] = sum[i] + nums[i];
        }
        
        long max = Long.MAX_VALUE;
        TreeMap<Long, Integer> tm = new TreeMap<Long, Integer>();
        tm.put(0l, 0);
        for(int i = 1; i <= len; i++){
            if(tm.ceilingKey(sum[i]) != null){
                long key = tm.ceilingKey(sum[i]);
                long diff = Math.abs(key - sum[i]);
                if(diff < max){
                    max = (int) diff;
                    first = tm.get(key);
                    last = i-1;
                }
            }
            
            if(tm.floorKey(sum[i]) != null){
                long key = tm.floorKey(sum[i]);
                long diff = Math.abs(key - sum[i]);
                if(diff < max){
                    max = (int) diff;
                    first = tm.get(key);
                    last = i-1;
                }
            }
            tm.put(sum[i], i);
        }
        if(first != -1){
            ret.add(first);
            ret.add(last);
        }
        
        return ret;
    }
}

