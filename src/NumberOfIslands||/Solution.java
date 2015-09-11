/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
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
            ArrayList<Point> neighbours = new ArrayList<Point>();
            int x = operators[i].x;
            int y = operators[i].y;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny]){
                    neighbours.add(new Point(nx, ny));
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
                for(HashSet<Pair> hs : tmp){
                
                } 
            }
            
        }
        return ret;
    }
}
