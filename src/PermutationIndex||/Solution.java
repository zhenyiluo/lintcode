public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndexII(int[] A) {
        // Write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        long ret = 1;
        long fac = 1;
        for(int i = A.length -1; i >=0; i--){
            int rank = 0;
            HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
            hm.put(A[i], 1);
            for(int j = i+1; j < A.length; j++){
                if(hm.containsKey(A[j])){
                    hm.put(A[j], hm.get(A[j]) + 1);
                }else{
                    hm.put(A[j], 1);
                }
                if(A[i] > A[j]){
                    rank ++;
                }
            }
            ret += rank * fac/ dupPerm(hm);
            fac *= A.length - i;
        }
        return ret;
    }
    
    public long dupPerm(HashMap<Integer, Integer> hm){
        if(hm.isEmpty()){
            return 1;
        }
        
        long ret = 1;
        for(Integer n : hm.values()){
            ret *= factor(n);
        }
        return ret;
    }
    
    HashMap<Integer, Long> cache = new HashMap<Integer, Long>();
    public long factor(int n){
        if(!cache.containsKey(n)){
            if(n == 1){
                cache.put(1, 1l);
            }else{
                long ret = n * factor(n-1);
                cache.put(n, ret);
            }
        }
        return cache.get(n);
        
    }
}
