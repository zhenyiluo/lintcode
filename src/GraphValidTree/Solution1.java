public class Solution1 {
    int[] id;
    int[] size;
    
    private int find(int x){
        while(x != id[x]){
            id[x] = id[id[x]];
            x = id[x];
        }
        return x;
    }
    
    private void union(int a, int b){
        if(size[a] < size[b]){
            id[a] = b;
            size[b] += size[a];
        }else{
            id[b] = a;
            size[a] += size[b];
        }
    }
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
        
        id = new int[n];
        size = new int[n];
        for(int i = 0; i < n; i++){
            id[i] = i;
            size[i] = 1;
        }
        
        for(int i = 0; i < m; i++){
            int a = edges[i][0];
            int b = edges[i][1];
            int x = find(a);
            int y = find(b);
            if(x == y){
                return false;
            }
            union(x, y);
        }
        
        return true;
    }
    
}