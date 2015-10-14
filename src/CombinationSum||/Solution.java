public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> ret = new ArrayList<>();
        if(num == null || num.length == 0 || target <= 0){
            return ret;
        }
        Arrays.sort(num);
        List<Integer> cur = new ArrayList<>();
        HashSet<List<Integer>> hs = new HashSet<>();
        dfs(num, target, 0, cur, ret, hs);
        return ret;
    }
    
    private void dfs(int[] num, int target, int start, List<Integer> cur, List<List<Integer>> ret, HashSet<List<Integer>> hs){
        if(target == 0){
            List<Integer> tmp = new ArrayList<Integer>(cur);
            if(!hs.contains(tmp)){
                ret.add(tmp);
                hs.add(tmp);
            }
            return;
        }
        
        for(int i = start; i < num.length; i++){
            if(num[i] > target){
                return;
            }
            cur.add(num[i]);
            dfs(num, target - num[i], i+1, cur, ret, hs);
            cur.remove(cur.size()-1);
        }
    }
}
