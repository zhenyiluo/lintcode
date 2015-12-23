import java.util.*;

public class Solution {


    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    /**
     * @param board a 2D board containing 'X' and 'O'
     * @return void
     */
    public void surroundedRegions(char[][] board) {
        // Write your code here
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }

        int m = board.length;
        int n = board[0].length;

        boolean[][] mark = new boolean[m][n];
        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            if(!mark[i][0] && board[i][0] == 'O'){
                mark[i][0] = true;
                q.add(i * n + 0);
            }
            if(!mark[i][n-1] && board[i][n-1] == 'O'){
                mark[i][n-1] = true;
                q.add(i * n + n-1);
            }
        }

        for(int j = 1; j < n-1; j++){
            if(!mark[0][j] && board[0][j] == 'O'){
                mark[0][j] = true;
                q.add(j);
            }

            if(!mark[m-1][j] && board[m-1][j] == 'O'){
                mark[m-1][j] = true;
                q.add((m-1) * n + j);
            }
        }

        
        while(!q.isEmpty()){
            int val = q.poll();
            int x = val / n;
            int y = val % n;
            for(int i = 0; i< 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && !mark[nx][ny] && board[nx][ny] == 'O'){
                    mark[nx][ny] = true;
                    q.add(nx * n + ny);
                }
            }
        }
        
        

        for(int i = 0; i <m; i++){
            for(int j = 0; j < n; j++){
                if(!mark[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

}
