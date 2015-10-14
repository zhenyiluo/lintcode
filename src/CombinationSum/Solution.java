public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> ret = new ArrayList<>();
        if(candidates == null || candidates.length == 0 || target <= 0){
            return ret;
        }
        Arrays.sort(candidates);
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        dfs(candidates, target, 0, list, ret);
        return ret;
    }
    
    private void dfs(int[] candidates, int target, int start, ArrayList<Integer> list, List<List<Integer>> ret){
        if(target == 0){
            ArrayList<Integer> tmp = new ArrayList<Integer>(list);
            ret.add(tmp);
            return;
        }        
        
        for(int i = start; i < candidates.length; i++){
            if(target < candidates[i]){
                return;
            }
            list.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, list, ret);
            list.remove(list.size()-1);
        }
    }
}
