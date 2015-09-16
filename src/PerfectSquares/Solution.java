import java.util.HashMap;

public class Solution {
    HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();
    public int numSquares(int n) {
        if(!cache.containsKey(n)){
            if(n <= 0){
                return 0;
            }
            
            if(n == 1){
                return 1;
            }
            if(n == 2){
                return 2;
            }
            if(n == 3){
                return 3;
            }
            int num = (int) Math.sqrt(n);
            int ret = Integer.MAX_VALUE;
            while(num >= 1){
                ret = Math.min(ret, 1 + numSquares(n - num *num));
                num--;
            }
            cache.put(n, ret);
        }
        return cache.get(n);
    }
}