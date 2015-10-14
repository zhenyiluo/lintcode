public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    public ArrayList<Integer> subarraySum(int[] nums) {
        // write your code here
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(nums == null || nums.length == 0){
            return ret;
        }
        int len = nums.length;
        int[] sums = new int[len+1];
        for(int i = 1; i <= len; i++){
            sums[i] = sums[i-1] + nums[i-1];
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        hm.put(0, 0);
        for(int i = 1; i <= len; i++){
            if(hm.containsKey(sums[i])){
                ret.add(hm.get(sums[i]));
                ret.add(i-1);
                return ret;
            }else{
                hm.put(sums[i], i);
            }
        }
        return ret;
    }
}
