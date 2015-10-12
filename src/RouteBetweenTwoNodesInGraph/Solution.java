/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
     HashSet<Integer> hs = new HashSet<Integer>();
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph, 
                            DirectedGraphNode s, DirectedGraphNode t) {
        // write your code here
        if(s.label == t.label){
            return  true;
        }
        hs.add(s.label);
        for(DirectedGraphNode node : s.neighbors){
            if(hs.contains(node.label)){
                continue;
            }
            if(hasRoute(graph, node, t)){
                return true;
            }
        }
        
        return false;
    }
}
