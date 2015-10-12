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
        int min = num[0];
        while(low <= high){
            int mid = low + ((high - low) >> 1);
            min = Math.min(min, num[mid]);
            if(num[mid] > num[high]){
                low = mid + 1;
            }else if(num[mid] < num[high]){
                high = mid-1;
            }else{
                high --;
            }
        }
        return min;
    }
}
