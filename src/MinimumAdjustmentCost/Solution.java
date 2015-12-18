public class Solution {
    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        if(A == null || A.size() == 0){
            return 0;
        }
        
        int size = A.size();
        
        int[][] dp = new int[size][101];
        
        
        for(int i = 0; i < size; i++){
            for(int j = 1; j <= 100; j++){
                dp[i][j] = Integer.MAX_VALUE;
                if(i == 0){
                    dp[i][j] = Math.abs(A.get(i) - j);
                }else{
                    for(int k = 1; k <= 100; k++){
                        if(Math.abs(j - k) > target){
                            continue;
                        }
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + Math.abs(A.get(i) -j));
                    }
                }
            }
        }
        
        int ret = Integer.MAX_VALUE;
        for(int i = 1; i <= 100; i++){
            ret = Math.min(ret, dp[size-1][i]);
        }
        return ret;
    }
}