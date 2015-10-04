public class Solution {
    /**
     * @param n: An integer.
     * return : An array storing 1 to the largest number with n digits.
     */
    public List<Integer> numbersByRecursion(int n) {
        // write your code here
        List<Integer> ret = new ArrayList<Integer>();
        if(n <= 0){
            return ret;
        }
        
        dfs(n, ret);
        
        return ret;
    }
    
    private int dfs(int n, List<Integer> ret){
        if(n == 0){
            return 1;
        }   
        
        int base = dfs(n-1, ret);
        int size = ret.size();
        for(int i = 1; i<=9; i++){
            int cur = base * i;
            ret.add(cur);
            for(int j = 0; j < size; j++){
                ret.add(cur + ret.get(j));
            }
        }
        
        return base * 10;
    }
}
