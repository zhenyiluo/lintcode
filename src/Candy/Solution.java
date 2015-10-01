public class Solution {
    /**
     * @param ratings Children's ratings
     * @return the minimum candies you must give
     */
    public int candy(int[] ratings) {
        // Write your code here
        if(ratings == null || ratings.length <1){
            return 0;
        }
        int len = ratings.length;
        if(len == 1){
            return 1;
        }
        int sum = len;
        int[] dp = new int[len];
        int k = 1;
        for(int i = 1; i < len; i++){
            if(ratings[i] > ratings[i-1]){
                dp[i] = Math.max(k++, dp[i]);
            }else{
                k = 1;
            }
        }
        
        k = 1;
        for(int i = len-2; i>= 0; i--){
            if(ratings[i] > ratings[i+1]){
                dp[i] = Math.max(k++, dp[i]);
            }else{
                k = 1;
            }
        }
        for(int n : dp){
            sum += n;
        }
        return sum;
    }
}
