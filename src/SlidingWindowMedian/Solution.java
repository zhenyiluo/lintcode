public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: The median of the element inside the window at each moving.
     */
    public ArrayList<Integer> medianSlidingWindow(int[] nums, int k) {
        // write your code here
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(nums == null || nums.length == 0 || nums.length < k){
            return ret;
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, Collections.reverseOrder());
        for(int i = 0; i < k; i++){
            addNum(minHeap, maxHeap, nums[i]);
            reBalance(minHeap, maxHeap);
        }
        ret.add(maxHeap.peek());
        
        for(int i = k; i < nums.length; i++){
            addNum(minHeap, maxHeap, nums[i]);
            removeNum(minHeap, maxHeap, nums[i-k]);
            reBalance(minHeap, maxHeap);
            ret.add(maxHeap.peek());
        }
        return ret;
    }
    
    private void addNum(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int num){
        if(maxHeap.isEmpty() || num < maxHeap.peek()){
            maxHeap.add(num);
        }else{
            minHeap.add(num);
        }
    }
    
    private void removeNum(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap, int num){
        if(num <= maxHeap.peek()){
            maxHeap.remove(num);
        }else{
            minHeap.remove(num);
        }
    }
    
    private void reBalance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap){
        if(maxHeap.size() - minHeap.size() > 1){
            minHeap.add(maxHeap.poll());
            return;
        }
        if(maxHeap.size() < minHeap.size()){
            maxHeap.add(minHeap.poll());
        }
    }
    
}

