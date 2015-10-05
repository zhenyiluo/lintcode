public class Solution {
    /**
     * @param A, B: Two integer arrays.
     * @return: Their smallest difference.
     */
    public int smallestDifference(int[] A, int[] B) {
        // write your code here
        if(A == null || A.length == 0 || B == null || B.length == 0){
            return 0;
        }
        
        Arrays.sort(A);
        Arrays.sort(B);
        int ret = Integer.MAX_VALUE;
        int i = 0; 
        int j = 0;
        while(i < A.length && j < B.length){
            ret = Math.min(ret, Math.abs(A[i] - B[j]));
            if(A[i] < B[j]){
                i++;
            }else if(A[i] > B[j]){
                j++;
            }else{
                return 0;
            }
        }
        return ret;
    }
}

