/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null){
            return null;
        }
        Queue<UndirectedGraphNode> q = new LinkedList<UndirectedGraphNode>();
        q.add(node);
        
        HashMap<Integer, UndirectedGraphNode> hm = new HashMap<Integer, UndirectedGraphNode>();
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        hm.put(newNode.label, newNode);
        while(!q.isEmpty()){
            UndirectedGraphNode cur = q.poll();
            UndirectedGraphNode copy = hm.get(cur.label);
            for(UndirectedGraphNode neighbor: cur.neighbors){
                if(!hm.containsKey(neighbor.label)){
                    UndirectedGraphNode nNode = new UndirectedGraphNode(neighbor.label);
                    hm.put(nNode.label, nNode);
                    q.add(neighbor);
                }
                copy.neighbors.add(hm.get(neighbor.label));
            }
        }
        return newNode;
    }
}
