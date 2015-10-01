class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices == null || prices.length <=1){
            return 0;
        }
        
        int ret = 0;
        for(int i = 1; i < prices.length; i++){
            ret += Math.max(prices[i] - prices[i-1], 0);
        }
        return ret;
    }
};
