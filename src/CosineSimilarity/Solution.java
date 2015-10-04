class Solution {
    /**
     * @param A: An integer array.
     * @param B: An integer array.
     * @return: Cosine similarity.
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        if(A == null || A.length == 0 || B == null || B.length == 0){
            return 2.0;
        }
        if(A.length != B.length){
            return 2.0;
        }
        int len = A.length;
        long sum1 = 0;
        long sum2 = 0; 
        long sum3 = 0;
        for(int i = 0; i < len; i++){
            sum1 += (long)A[i] * B[i];
            sum2 += (long)A[i] * A[i];
            sum3 += (long)B[i] * B[i];
        }
        if(sum2 == 0 || sum3 == 0){
            return 2.0;
        }
        return (double) sum1 / (Math.sqrt(sum2) * Math.sqrt(sum3));
    }
}

