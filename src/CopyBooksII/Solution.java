public class Solution {
    /**
     * @param n: an integer
     * @param times: an array of integers
     * @return: an integer
     */
    public int copyBooksII(int n, int[] times) {
        // write your code here
        if(n <= 0 || times == null || times.length == 0){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int len = times.length;
        for(int i = 0; i < len; i++){
            min = Math.min(min, times[i]);
            max = Math.max(max, times[i]);
        }
        
        int left = n * min / len;
        int right = n * max / len;
        while(left <= right){
            int mid = left + ((right -left) >> 1);
            if(isValid(mid, times, n)){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean isValid(int val, int[] times, int n){
        int total = 0;
        for(int time: times){
            total += val / time;
        }
        return total >= n;
    }
}