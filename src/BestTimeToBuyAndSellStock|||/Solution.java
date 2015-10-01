class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int len = prices.length;
        int[] profit1 = new int[len];
        int[] profit2 = new int[len];
        profit1[0] = 0;
        int min = prices[0];
        for(int i = 1; i < len; i++){
            min = Math.min(prices[i], min);
            profit1[i] = Math.max(prices[i] - min, profit1[i-1]);
        }
        profit2[len-1] = 0;
        int max = prices[len-1];
        for(int i = len-2; i>= 0; i--){
            max = Math.max(prices[i], max);
            profit2[i] = Math.max(max - prices[i], profit2[i+1]);
        }
        int ret = 0;
        for(int i = 0; i < len; i++){
            ret = Math.max(ret, profit1[i] + profit2[i]);
        }
        return ret;
    }
};
