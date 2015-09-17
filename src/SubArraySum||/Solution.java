public class Solution {
    /**
     * @param A an integer array
     * @param start an integer
     * @param end an integer
     * @return the number of possible answer
     */
    public int subarraySumII(int[] A, int start, int end) {
        // Write your code here
        int len = A.length;
        int[] a = new int[len+1];
        for(int i = 0; i < len; i++){
            a[i+1] = a[i] + A[i];
        }
        int ret = 0;
        for(int i = 0; i < len; i++){
            for(int j = i+1; j <= len; j++){
                int num = a[j] -a[i];
                if(num >= start && num <= end){
                    ret++;
                }
            }
        }
        return ret;
    }
}
