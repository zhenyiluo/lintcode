public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length == 0){
            return 0;
        }
        
        int low = 0; 
        int high = num.length -1;
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(num[mid] > num[num.length -1]){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return num[low];
    }
}


public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length == 0){
            return 0;
        }
        
        int low = 0;
        int high = num.length -1;
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            if(num[mid] > num[num.length -1]){
                low = mid + 1;
            }else if(nums[mid] < nums[num{
                
            }
        }
    }
}
