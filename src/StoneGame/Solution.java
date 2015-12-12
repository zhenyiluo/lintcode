public class Solution {
    
    /**
     * @param A an integer array
     * @return an integer
     */
    public int stoneGame(int[] A) {
        // Write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        if(A.length == 1){
            return 0;
        }

        int len = A.length;
        int[][] dp = new int[len][len];

        int[] preSum = new int[len+1];
        for(int i = 0; i < len; i++){
            preSum[i+1] = preSum[i] + A[i];
        }

        for(int i = len -1; i>= 0; i--){
            for(int j = i+1; j < len; j++){
                if(j == i+1){
                    dp[i][j] = preSum[j+1] - preSum[i];
                }else{
                    int min = Integer.MAX_VALUE;
                    for(int k = i; k < j; k++){
                        min = Math.min(min, dp[i][k] + dp[k+1][j]);
                    }
                    dp[i][j] = preSum[j+1] - preSum[i] + min;
                }
            }
        }

        return dp[0][len-1];
    }

}