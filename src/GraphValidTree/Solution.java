public class Solution {
    /**
     * @param n an integer
     * @param edges a list of undirected edges
     * @return true if it's a valid tree, or false
     */
    public boolean validTree(int n, int[][] edges) {
        // Write your code here
        if(n <= 0 || edges == null){
            return false;
        }
        
        int m = edges.length;
        if (n != m+1){
            return false;
        }
        
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < m; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }
        
        boolean[] visited = new boolean[n];
        int[] cnt = new int[1];
        visited[0] = true;
        dfs(0, visited, graph, cnt);
        return cnt[0] == n;
    }
    
    private void dfs(int cur, boolean[] visited, ArrayList<Integer>[] g, int[] cnt){
        cnt[0] ++;
        for(int neighbor : g[cur]){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                dfs(neighbor, visited, g, cnt);
            }
        }
    }
}