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
        
        for(int i = 1; i < m-1; i++){
            int j = findLargest(A[i], 1, n-2);
            if(A[i][j] > A[i-1][j] && A[i][j] > A[i+1][j]){
                ret.add(i);
                ret.add(j);
                return ret;
            }
        }
        
        return ret;
    }
    
    private int findLargest(int[] A, int start, int end){
        int mid = start + ((end - start) >> 1);
        if(A[mid] < A[mid-1]){
            return findLargest(A, start, mid-1);
        }else if(A[mid]  < A[mid+1]){
            return findLargest(A, mid +1, end);
        }else{
            return mid;
        }
    }
}

