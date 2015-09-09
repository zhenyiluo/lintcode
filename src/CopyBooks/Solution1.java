// O(n^2 k) 1339 ms
public class Solution1 {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int left = 1;
        int right = (int) (1e9);
        int ret = 0;
        while(left <= right){
            int mid = left + ((right -left)>>1);
            if(check(pages, mid, k)){
                ret = mid;
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return ret;
    }
    
    private boolean check(int[] pages, int total, int k){
        int sum = 0;
        int count = 0;
        for(int i = 0; i < pages.length; ){
            if(sum + pages[i] <= total){
                sum += pages[i++];
            }else if(pages[i] <= total){
                sum = 0;
                count++;
            }else{
                return false;
            }
        }
        if(sum != 0){
            count ++;
        }
        return count <= k;
    }
}
