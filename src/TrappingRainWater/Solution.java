public class Solution {
    /**
     * @param heights: an array of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        // write your code here
        if(heights == null || heights.length < 2){
            return 0;
        }
        
        int i = 0; 
        int j = heights.length -1;
        int lMax = 0; 
        int rMax = 0;
        int ret = 0;
        while(i <= j){
            lMax = Math.max(lMax, heights[i]);
            rMax = Math.max(rMax, heights[j]);
            
            if(lMax < rMax){
                ret += lMax - heights[i++];
            }else{
                ret += rMax - heights[j--];
            }
        }
        return ret;
    }
}
