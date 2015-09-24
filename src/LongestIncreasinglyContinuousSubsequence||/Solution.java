public class Solution {
    /**
     * @param A an integer matrix
     * @return  an integer
     */
     int n;
     int m;
    public int longestIncreasingContinuousSubsequenceII(int[][] A) {
        // Write your code here
        if(A == null || A.length == 0 || A[0].length == 0){
            return 0;
        }
        n = A.length;
        m = A[0].length;
        int[][] score = new int[n][m];
        int ret = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(score[i][j] == 0){
                    ret = Math.max(ret, dfs(A, i, j, score));
                }
            }
        }
        return ret;
    }
    final int[] dx = {-1, 1, 0, 0};
    final int[] dy = {0, 0, -1, 1};
    public int dfs(int[][] A, int i, int j, int[][] score){
        if(score[i][j] != 0){
            return score[i][j];
        }
        int[] val = new int[4];
        for(int k = 0; k < 4; k++){
            int nx = i + dx[k];
            int ny = j + dy[k];
            if(nx >= 0 && ny >= 0 && nx < n && ny < m && A[nx][ny] > A[i][j]){
                val[k] = dfs(A, nx, ny, score);
            }
        }
        
        for(int k = 0; k < 4; k++){
            score[i][j] = Math.max(score[i][j], val[k]);
        }
        score[i][j] ++;
        return score[i][j];
    }
}
