// O(n^2 k) 1339 ms
public class Solution1 {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        int m = pages.length;
        int[][] dp = new int[k+1][m+1];
        int sum = 0; 
        int max = 0;
        for(int i = 0; i < m; i++){
            sum += pages[i];
            dp[1][i+1] = sum;
            max = Math.max(pages[i], max);
        }
        
        if(k >= m){
            return max;
        }
        
        for(int i = 2; i <= k; i++){
            for(int j = m-1; j >= i-1; j--){
                int cur = pages[j];
                int min = Math.max(cur, dp[i-1][j]);
                dp[i][j+1] = min;
                for(int l = j-1; l >= i-1; l--){
                    cur += pages[l];
                    int curMin = Math.max(cur, dp[i-1][l]);
                    if(curMin < min){
                        dp[i][j+1] = curMin;
                        min = curMin;
                    }
                }
            }
        }
        return dp[k][m];
    }
}
