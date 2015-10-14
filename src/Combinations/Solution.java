public class Solution {
    /**
     * @param n: Given the range of numbers
     * @param k: Given the numbers of combinations
     * @return: All the combinations of k numbers out of 1..n
     */
    public List<List<Integer>> combine(int n, int k) {
		// write your code here
		List<List<Integer>> ret = new ArrayList<>();
		if(n <= 0 || k <= 0 || k > n){
		    return ret;
		}
		return dfs(1, n, k);
    }
    
    private List<List<Integer>> dfs(int start, int end, int k){
        List<List<Integer>> ret = new ArrayList<>();
        if(k == 0){
            ret.add(new ArrayList<Integer>());
            return ret;
        }
        
        for(int i = start; i <= end - k + 1; i++){
            for(List<Integer> list : dfs(i + 1, end, k-1)){
                list.add(0, i);
                ret.add(list);
            }
        }
        return ret;
    }
}
