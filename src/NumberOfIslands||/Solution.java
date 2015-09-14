/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
// TLE with this solution
public class Solution {
    /**
     * @param n an integer
     * @param m an integer
     * @param operators an array of point
     * @return an integer array
     */
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> ret = new LinkedList<Integer>();
        if(operators == null){
            return ret;
        }
        boolean[][] visited = new boolean[n][m];
        List<HashSet<Pair>> lists = new LinkedList<HashSet<Pair>>();
        for(int i = 0; i < operators.length; i++){
            ArrayList<Pair> neighbours = new ArrayList<Pair>();
            int x = operators[i].x;
            int y = operators[i].y;
            for(int j = 0; j < 4; j++){
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny]){
                    neighbours.add(new Pair(nx, ny));
                }
            }
            if(neighbours.size()== 0){
                HashSet<Pair> hs = new HashSet<Pair>();
                hs.add(new Pair(x, y));
                lists.add(hs);
                ret.add(lists.size());
                visited[x][y] = true;
            }else{
                List<HashSet<Pair>> tmp = lists;
                lists = new LinkedList<HashSet<Pair>>();
                HashSet<Pair> merge = new HashSet<Pair>();
                for(HashSet<Pair> hs : tmp){
                    if(!contains(hs, neighbours, merge)){
                        lists.add(hs);
                    }
                } 
                merge.add(new Pair(x, y));
                lists.add(merge);
                ret.add(lists.size());
                visited[x][y] = true;
            }
            
        }
        return ret;
    }
    
    public boolean contains(HashSet<Pair> hs, ArrayList<Pair> neighbours, HashSet<Pair> merge){
        boolean flag = false;
        for(Pair neighbour : neighbours){
            if(hs.contains(neighbour)){
                merge.addAll(hs);
                flag = true;
            }
        }
        return flag;
    }
    
    static class Pair{
        int x;
        int y;
        public Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
        public boolean equals(Object obj){
            Pair pair = (Pair) obj;
            return this.x == pair.x && this.y == pair.y;
        }
        public int hashCode(){
            return 10 * x + y;
        }
    }
}
