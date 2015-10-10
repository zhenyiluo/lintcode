public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The maximum number inside the window at each moving.
     */
    public ArrayList<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(nums == null || nums.length < k || nums.length == 0 || k <= 0){
            return ret;
        }
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < nums.length; i++){
            while(!list.isEmpty() && nums[list.getLast()] <= nums[i]){
                list.removeLast();
            }
            list.addLast(i);
            if(i + 1 - list.getFirst() > k){
                list.removeFirst();
            }
            if(i+1-k >=0){
                ret.add(nums[list.getFirst()]);
            }
        }
        return ret;
    }
}

