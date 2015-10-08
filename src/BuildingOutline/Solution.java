public class Solution {
    /**
     * @param buildings: A list of lists of integers
     * @return: Find the outline of those buildings
     */
    public ArrayList<ArrayList<Integer>> buildingOutline(int[][] buildings) {
        // write your code here
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if(buildings == null || buildings.length == 0 || buildings[0].length == 0){
            return ret;
        }
        Pair[] pairs = new Pair[buildings.length * 2];
        for(int i = 0; i < buildings.length; i++){
            pairs[2* i] = new Pair(buildings[i][0], buildings[i][2]);
            pairs[2* i+1] = new Pair(buildings[i][1], -buildings[i][2]);
        }
        
        Arrays.sort(pairs, new Comparator<Pair>(){
            @Override 
            public int compare(Pair pair1, Pair pair2){
                if(pair1.first != pair2.first){
                    return pair1.first - pair2.first;
                }
                return pair2.second - pair1.second;
            }
        });
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(10, new Comparator<Integer>(){
            @Override
            public int compare(Integer i1, Integer i2){
                return i2 - i1;
            }
        });
        
        int prev = 0;
        int cur = 0;
        for(int i = 0; i < pairs.length; i++){
            Pair pair = pairs[i];
            if(pair.second > 0){
                pq.add(pair.second);
                cur = pq.peek();
            }else{
                pq.remove(-pair.second);
                if(pq.isEmpty()){
                    cur = 0;
                }else{
                    cur = pq.peek();
                }
            }
            
            if(cur != prev){
                if(pq.isEmpty()){
                    ArrayList<Integer> list = ret.get(ret.size()-1);
                    list.add(1, pair.first);
                }else{
                    if(prev != 0){
                        ArrayList<Integer> list1 = ret.get(ret.size()-1);
                        list1.add(1, pair.first); 
                    }
                    ArrayList<Integer> list2 = new ArrayList<Integer>();
                    list2.add(pair.first);
                    list2.add(cur);
                    ret.add(list2);
                }   
                prev = cur;
            }
        }
        return ret;
    }
    
    static class Pair{
        int first;
        int second;
        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}

