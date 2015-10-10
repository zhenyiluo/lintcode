class Solution {
    /**
      * @param n: n
      * @param k: the kth permutation
      * @return: return the k-th permutation
      */
    public String getPermutation(int n, int k) {
        int[] f = new int[10];
        f[1] = 1;
        for(int i = 2; i < 10; i ++){
            f[i] = f[i-1] * i;
        }
        
        if(k < 1 || k > f[n]){
            return "invalid input";
        }
        
        StringBuilder ret = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= n; i++){
            list.add(i);
        }
        k--;
        while(n > 0){
            
            if(n == 1){
                ret.append(list.remove(0));
                break;
            }
            
            int val = k / f[n-1];
            ret.append(list.remove(val));
            k -= f[n-1] * (val);
            
            n--;
        }
        
        
        return ret.toString();
    }
}

