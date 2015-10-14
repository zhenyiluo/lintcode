class Solution {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if(x <= 0){
            return 0;
        }
        if(x == 1){
            return 1;
        }
        
        int low = 1; 
        int high = x /2;
        while(low <= high){
            long mid = low + ((high - low) >> 1);
            if(mid * mid <= x){
                low = (int)(mid +1);
            }else{
                high = (int)(mid -1);
            }
        }
        return high;
    }
}
