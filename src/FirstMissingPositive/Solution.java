public class Solution {
    /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        if(A == null || A.length == 0){
            return 1;
        }
        
        int n = A.length;
        for(int i = 0; i < A.length; i++){
            while(A[i] != i+1){
                if(A[i] <= 0 || A[i] > n){
                    break;
                }
                
                if(A[i] == A[A[i] -1]){
                    break;
                }
                
                int tmp = A[i];
                A[i] = A[tmp -1];
                A[tmp -1] = tmp;
            }
        }
        
        for(int i = 0 ; i < A.length; i++){
            if(A[i] != i+1){
                return i+1;
            }
        }
        return n+1;
    }
}
