import java.util.HashMap;

public class Solution {
    
//    public static void main(String[] args){
//        int[] values = {1, 20, 4};
//        System.out.println(new Solution().firstWillWin(values));
//    }
    /**
     * @param values: an array of integers
     * @return: a boolean which equals to true if the first player will win
     */
    public boolean firstWillWin(int[] values) {
        // write your code here
        if(values == null || values.length == 0){
            return false;
        }
        
        if(values.length == 1){
            return true;
        }
        
        long sum = 0;
        for(int value : values){
            sum += value;
        }
        
        long val = dfs(values, 0, values.length-1);
        if(val * 2 > sum){
            return true;
        }else{
            return false;
        }
    }
    HashMap<String, Long> cache = new HashMap<String, Long>();
    public long dfs(int[] values, int start, int end){
        if(start > end){
            return 0;
        }
        
        if(start == end){
            return values[start];
        }
        String key = start + "#" + end;
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        
        long ret = 0;
        
        ret = Math.max(values[start] + Math.min(dfs(values, start+2, end) , dfs(values, start+1, end-1) ), 
                    values[end] + Math.min(dfs(values, start+1, end-1) , dfs(values, start, end-2) ));
        
        cache.put(key, ret);
        return ret;
    }
    
}
