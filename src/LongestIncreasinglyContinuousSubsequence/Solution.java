public class Solution {
    /**
     * @param A an array of Integer
     * @return  an integer
     */
    public int longestIncreasingContinuousSubsequence(int[] A) {
        // Write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int ret1 = 1;
        int ret2 = 1;
        int val1 = 1;
        int val2 = 1;
        int prev = A[0];
        for(int i = 1; i< A.length; i++){
            int num = A[i];
            if(num > prev){
                val1++;
                ret1 = Math.max(ret1, val1);
                val2 = 1;
            }else if(num < prev){
                val1 = 1;
                val2 ++;
                ret2 = Math.max(ret2, val2);
            }else{
                val1 = 1;
                val2 = 1;
            }
            prev = num;
        }
        return Math.max(ret1, ret2);
    }
}
