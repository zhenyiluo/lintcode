public class Solution {
    /**
     * @param nums: A list of integers.
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if(nums.length == 0){
            return new int[0];
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i1 - i2;
            }
        });
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        
        int[] ret = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(minHeap.size() == maxHeap.size()){
                if(!minHeap.isEmpty() && num > minHeap.peek()){
                    maxHeap.add(minHeap.poll());
                    minHeap.add(num);
                }else{
                    maxHeap.add(num);
                }
            }else{
                if(num < maxHeap.peek()){
                    minHeap.add(maxHeap.poll());
                    maxHeap.add(num);
                }else{
                    minHeap.add(num);
                }
            }
            ret[i] = maxHeap.peek();
        }
        return ret;
    }
}
