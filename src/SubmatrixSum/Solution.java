public class Solution {
    /**
     * @param matrix an integer matrix
     * @return the coordinate of the left-up and right-down number
     */
    public int[][] submatrixSum(int[][] matrix) {
        // Write your code here
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] sum = new int[m+1][n+1];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                sum[i+1][j+1] = matrix[i][j] + sum[i][j+1] + sum[i+1][j] 
                -sum[i][j];
            }
        }
        
        int[][] ret = new int[2][2];
        
        for(int l = 0; l <= m; l++){
            for(int h = l+1; h <= m; h++){
                HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
                for(int k = 0; k <= n; k++){
                    int tmp = sum[h][k] - sum[l][k];
                    if(hm.containsKey(tmp)){
                        int prevK = hm.get(tmp);
                        ret[0][0] = l;
                        ret[0][1] = prevK;
                        ret[1][0] = h-1;
                        ret[1][1] = k-1;
                    }else{
                        hm.put(tmp, k);
                    }
                }
            }
        }
        return ret;
    }
}
