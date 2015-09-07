public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        boolean[] dp = new boolean[m+1];
        dp[0] = true;
        for(int n: A){
            for(int i = m; i >= 0; i--){
                if(i + n <= m){
                    dp[i+n] |= dp[i];
                }
            }
        }
        
        for(int i = m; i>=0; i--){
            if(dp[i]){
                return i;
            }
        }
        return -1;
    }
}
