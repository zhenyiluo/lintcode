public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        
        long[] f = new long[A.length+1];
        f[1] = 1;
        for(int i = 2; i <= A.length; i++){
            f[i] = f[i-1] * i;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int n : A){
            list.add(n);
        }
        long ret = 0;
        Collections.sort(list);
        for(int i = 0; i < A.length; i++){
            int index = list.indexOf(A[i]);
            ret += f[list.size() -1] * index;
            list.remove(index);
        }
        return ret+1;
    }
}

// Another solution:
public class Solution {
    /**
     * @param A an integer array
     * @return a long integer
     */
    public long permutationIndex(int[] A) {
        // Write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        
        long ret = 1;
        long fac = 1;
        for(int i = A.length -1; i >= 0; i--){
            int rank = 0;
            for(int j = i+1; j < A.length; j++){
                if(A[i] > A[j]){
                    rank ++;
                }
            }
            ret += rank * fac;
            fac *= A.length - i;
        }
        return ret;
    }
}

