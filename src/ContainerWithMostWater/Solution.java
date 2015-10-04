public class Solution {
    /**
     * @param heights: an array of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // write your code here
        if(heights == null || heights.length <2){
            return 0;
        }
        
        int start = 0;
        int end = heights.length -1;
        int ret = 0;
        while(start < end){
            ret = Math.max(ret, Math.min(heights[start], heights[end]) * (end - start));
            if(heights[start] < heights[end]){
                start ++;
            }else if(heights[start] > heights[end]){
                end --;
            }else{
                start ++;
                end --;
            }
        }
        
        
        return ret;
    }
}
