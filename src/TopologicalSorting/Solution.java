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
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> ret = new ArrayList<DirectedGraphNode>();
        if(graph == null || graph.size() == 0){
            return ret;
        }
        int size = graph.size();
        HashMap<DirectedGraphNode, Integer> hm = new HashMap<DirectedGraphNode, Integer>();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(hm.containsKey(neighbor)){
                    hm.put(neighbor, hm.get(neighbor) + 1);
                }else{
                    hm.put(neighbor, 1);
                }
            }
        }
        HashSet<DirectedGraphNode> tmp = new HashSet<>(graph);
        while(ret.size() != size){
            Iterator<DirectedGraphNode> iterator = tmp.iterator();
            while(iterator.hasNext()){
                DirectedGraphNode node = iterator.next();
                if(!hm.containsKey(node)){
                    ret.add(node);
                    iterator.remove();
                    
                    for(DirectedGraphNode neighbor: node.neighbors){
                        if(hm.containsKey(neighbor)){
                            int val = hm.get(neighbor)-1;
                            if(val == 0){
                                hm.remove(neighbor);
                            }else{
                                hm.put(neighbor, val);
                            }
                        }
                    }
                }
            }
        }
        return ret;
    }
}
