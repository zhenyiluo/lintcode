class Solution {
    /**
     * @param A: An integer matrix
     * @return: The index of the peak
     */
    public List<Integer> findPeakII(int[][] A) {
        // write your code here
        List<Integer> ret = new ArrayList<Integer>();
        if(A == null || A.length == 0 || A[0].length == 0){
            return ret;
        }
        
        int m = A.length;
        int n = A[0].length;
        if(m <= 2 || n <= 2){
            return ret;
        }
        
        int i = 1; 
        int j = 1;
        while(true){
            if(A[i][j] > A[i+1][j] && A[i][j] > A[i][j+1]){
                ret.add(i);
                ret.add(j);
                return ret;
            }
            if(A[i+1][j] > A[i][j+1]){
                i++;
            }else{
                j++;
            }
        }
    }
}

