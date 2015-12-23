public class Solution {
    /**
     * @param A: an integer array.
     * @param k: a positive integer (k <= length(A))
     * @param target: a integer
     * @return an integer
     */
    public int kSum(int A[], int k, int target) {
        // write your code here
        if(A == null || A.length <= 0){
            return 0;
        }
        
        int[][] dp = new int[k+1][target+1];
        dp[0][0] = 1;
        int n = A.length;
        for(int i = 0; i < n; i++){
            int val = A[i];
            for(int j = k; j >= 1; j--){
                for(int l = target; l >= val; l--){
                    dp[j][l] += dp[j-1][l-val];
                }
            }
        }
        return dp[k][target];
    }
}
