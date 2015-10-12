public class Solution {
    /**
     * @paramn n: An integer
     * @return: An integer
     */
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public int numTrees(int n) {
        if(cache.containsKey(n)){
            return cache.get(n);
        }
        // write your code here
        if(n == 0 || n == 1){
            cache.put(n, 1);
            return 1;
        }
        
        int sum = 0;
        for(int k = 1; k <= n; k++){
            sum += numTrees(k-1) * numTrees(n-k);
        }
        cache.put(n, sum);
        return sum;
    }
}
