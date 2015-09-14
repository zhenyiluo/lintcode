/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Directed graph node
     * @return a connected set of a directed graph
     */
    int[] id;
    int[] sz;
    public int find(int x){
        while(x != id[x]){
            id[x] = id[id[x]];
            x = id[x];
        }
        return x;
    }
    
    public void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j){
            return;
        }
        
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
    }
    
    public List<List<Integer>> connectedSet2(ArrayList<DirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        
        if(nodes == null || nodes.size() == 0){
            return ret;
        }
        
        int n = nodes.size();
        id = new int[n];
        sz = new int[n];
        HashMap<DirectedGraphNode, Integer> hm = new HashMap<DirectedGraphNode, Integer>();
        for(int i = 0; i< n; i++){
            id[i] = i;
            sz[i] = 1;
            hm.put(nodes.get(i), i);
        }
        
        for(DirectedGraphNode node : nodes){
            for(DirectedGraphNode neighbor: node.neighbors){
                union(hm.get(node), hm.get(neighbor));
            }
        }
        
        HashMap<Integer, List<Integer>> hm1 = new HashMap<Integer, List<Integer>>();
        for(DirectedGraphNode node : nodes){
            int num = find(hm.get(node));
            if(hm1.get(num) == null){
                hm1.put(num, new ArrayList<Integer>());
            }
            List<Integer> list = hm1.get(num);
            list.add(node.label);
        }
        for(int key : hm1.keySet()){
            List<Integer> list = new ArrayList<Integer>(hm1.get(key));
            Collections.sort(list);
            ret.add(list);
        }
        return ret;
    }
}
