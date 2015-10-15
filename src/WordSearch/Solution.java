public class Solution {
    /**
     * @param board: A list of lists of character
     * @param word: A string
     * @return: A boolean
     */
     boolean[][] visited;
     int m;
     int n;
     char[][] board;
    public boolean exist(char[][] board, String word) {
        // write your code here
        if(board == null || word == null || board.length == 0 || board[0].length == 0 || word.length() == 0){
            return false;
        }
        
        m = board.length;
        n = board[0].length;
        this.board = board;
        if(m * n < word.length()){
            return false;
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == word.charAt(0)){
                    visited = new boolean[m][n];
                    visited[i][j] = true;
                    if(dfs(i, j, 1, word)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    private boolean dfs(int x, int y, int start, String word){
        if(start == word.length()){
            return true;
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny] && board[nx][ny] == word.charAt(start)){
                visited[nx][ny] = true;
                if(dfs(nx, ny, start+1, word)){
                    return true;
                }
                visited[nx][ny] = false;
            }
        }
        return false;
    }
}
