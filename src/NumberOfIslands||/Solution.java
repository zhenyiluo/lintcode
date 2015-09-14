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
    static int[] id;
    static int[] sz;
    static boolean[][] visited;
    public static int find(int x){
        while(x != id[x]){
            id[x] = id[id[x]];
            x = id[x];
        }
        return x;
    }
    
    public static void union(int p, int q){
        int i = find(p);
        int j = find(q);
        if(i == j){
            return ;
        }
        if(sz[i] < sz[j]){
            id[i] = j;
            sz[j] += sz[i];
        }else{
            id[j] = i;
            sz[i] += sz[j];
        }
    }
    public static final int[] dx = {-1, 1, 0, 0};
    public static final int[] dy = {0, 0, 1, -1}; 
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        List<Integer> ret = new LinkedList<Integer>();
        if(operators == null || operators.length == 0){
            return ret;
        }
        id = new int[n * m];
        sz = new int[n * m];
        for(int i = 0; i < n * m; i++){
            id[i] = i;
            sz[i] = 1;
        }
        
        int cnt = 0;
        int len = operators.length;
        visited = new boolean[n][m];
        for(int i = 0; i < len; i++){
            Point point = operators[i];
            int x = point.x;
            int y = point.y;
            if(visited[x][y]){
                ret.add(cnt);
                continue;
            }
            cnt++;
            visited[x][y] = true;
            int p = find(x * m + y);
            for(int j = 0; j < 4; j++){
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && visited[nx][ny]){
                    int q = find(nx * m + ny);
                    if(p != q){
                        cnt --;
                        union(p, q);
                        p = find(x * m + y);
                    }
                }
            }
            ret.add(cnt);
        }
        return ret;
    }
}