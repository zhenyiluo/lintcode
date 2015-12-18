public class Solution2 {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int m = pages.length;
        if(k >= m){
            return max(pages);
        }
        
        int sum = 0;
        for(int page : pages){
            sum += page;
        }
        
        int lowerBound = sum / k;
        int upperBound = sum;
        return binarySearch(pages, lowerBound, upperBound, k);
    }
    
    private int binarySearch(int[] pages, int left, int right, int k){
        while(left <= right){
            int mid = left + ((right - left) >> 1);
            if(isValid(mid, pages, k)){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
    
    private boolean isValid(int minute, int[] pages, int k){
        int m = pages.length;
        int cnt = 1;
        int tmp = minute;
        for(int page : pages){
            if(page > minute){
                return false;
            }
            if(page > tmp){
                cnt ++;
                tmp = minute - page;
            }else{
                tmp -= page;
            }
        }
        return cnt <= k;
    }
    
    private int max(int[] pages){
        int ret = 0;
        for(int i = 0; i < pages.length; i++){
            ret = Math.max(ret, pages[i]);
        }
        return ret;
    }
}