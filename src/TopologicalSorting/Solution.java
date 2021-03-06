// DFS
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
        ArrayList<DirectedGraphNode> ret = new ArrayList<>();
        if(graph == null || graph.size() == 0){
            return ret;
        }
        HashMap<DirectedGraphNode, Integer> hm = new HashMap<>();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(hm.containsKey(neighbor)){
                    hm.put(neighbor, hm.get(neighbor) + 1);
                }else{
                    hm.put(neighbor, 1);
                }
            }
        }
        HashSet<DirectedGraphNode> hs = new HashSet<>();
        for(DirectedGraphNode node : graph){
            if(hs.contains(node)){
                continue;
            }
            if(!hm.containsKey(node)){
                dfs(node, hm, hs, ret);
            }
        }
        
        return ret;
    }
    
    private void dfs(DirectedGraphNode node, HashMap<DirectedGraphNode, Integer> hm, HashSet<DirectedGraphNode> hs, ArrayList<DirectedGraphNode> ret){
                ret.add(node);
                hs.add(node);
                for(DirectedGraphNode neighbor: node.neighbors){
                    if(hm.containsKey(neighbor)){
                        int val = hm.get(neighbor)-1;
                        if(val == 0){
                            hm.remove(neighbor);
                            dfs(neighbor, hm, hs, ret);
                        }else{
                            hm.put(neighbor, val);
                        }
                    }
                }
    }
}


// BFS:
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
        ArrayList<DirectedGraphNode> ret = new ArrayList<>();
        if(graph == null || graph.size() == 0){
            return ret;
        }
        HashMap<DirectedGraphNode, Integer> hm = new HashMap<>();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neighbor : node.neighbors){
                if(hm.containsKey(neighbor)){
                    hm.put(neighbor, hm.get(neighbor) + 1);
                }else{
                    hm.put(neighbor, 1);
                }
            }
        }
        
        Queue<DirectedGraphNode> q = new LinkedList<>();
        for(DirectedGraphNode node : graph){
            if(!hm.containsKey(node)){
                q.add(node);
                ret.add(node);
            }
        }
        
        while(!q.isEmpty()){
            DirectedGraphNode node = q.poll();
            for(DirectedGraphNode neighbor : node.neighbors){
                if(hm.containsKey(neighbor)){
                    int val = hm.get(neighbor) -1;
                    if(val == 0){
                        hm.remove(neighbor);
                        ret.add(neighbor);
                        q.add(neighbor);
                    }else{
                        hm.put(neighbor, val);
                    }
                }
            }
        }
        return ret;
    }
}


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
