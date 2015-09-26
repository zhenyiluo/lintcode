class Solution {
    /**
     * @param n: an integer
     * @return an integer f(n)
     */
    HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
    public int fibonacci(int n) {
        // write your code here
        if(n == 1){
            return 0;
        }
        
        if(n == 2){
            return 1;
        }
        if(hm.containsKey(n)){
            return hm.get(n);
        }
        hm.put(n, fibonacci(n-1) + fibonacci(n-2));
        return hm.get(n);
    }
}


