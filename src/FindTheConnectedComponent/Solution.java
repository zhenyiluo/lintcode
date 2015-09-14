/**
 * Definition for Undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param nodes a array of Undirected graph node
     * @return a connected set of a Undirected graph
     */
     HashSet<UndirectedGraphNode> hs;
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if(nodes == null || nodes.size() == 0){
            return ret;
        }
        hs = new HashSet<UndirectedGraphNode>();
        for(int i = 0; i < nodes.size(); i ++){
            UndirectedGraphNode cur = nodes.get(i);
            if(hs.contains(cur)){
                continue;
            }
            List<Integer> list = dfs(cur);
            Collections.sort(list);
            ret.add(list);
        }
        return ret;
    }
    
    public List<Integer> dfs(UndirectedGraphNode node){
        List<Integer> ret = new ArrayList<Integer>();
        ret.add(node.label);
        hs.add(node);
        for(UndirectedGraphNode neighbor : node.neighbors){
            if(hs.contains(neighbor)){
                continue;
            }
            for(Integer n : dfs(neighbor)){
                ret.add(n);
            }
        }
        return ret;
    }
}
