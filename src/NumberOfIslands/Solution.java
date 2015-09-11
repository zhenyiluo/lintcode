public class Solution {
    /**
     * @param grid a boolean 2D matrix
     * @return an integer
     */
    public int m;
    public int n;
    public int numIslands(boolean[][] grid) {
        // Write your code here
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int ret = 0;
        m = grid.length;
        n = grid[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j]){
                    ret++;
                    grid[i][j] = false;
                    dfs(grid, i, j);
                }
            }
        }
        return ret;
    }
    
    public static final int[] dx = {1, -1, 0, 0};
    public static final int[] dy = {0, 0, -1, 1};
    private void dfs(boolean[][] grid, int x, int y){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < m && ny < n && grid[nx][ny]){
                grid[nx][ny] = false;
                dfs(grid, nx, ny);
            }
        }
    }
}
