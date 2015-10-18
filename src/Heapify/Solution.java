public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        Arrays.sort(A);
    }
}


public class Solution {
    /**
     * @param A: Given an integer array
     * @return: void
     */
    public void heapify(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return;
        }
        
        for(int i = A.length/2; i>= 0; i--){
            shiftDown(A, i);
        }
    }
    
    private void shiftDown(int[] A, int k){
        while(k < A.length){
            int small = k;
            int left = 2 * k + 1;
            if(left < A.length && A[left] < A[small]){
                small = left;
            }
            int right = 2 * k + 2;
            if(right < A.length && A[right] < A[small]){
                small = right;
            }
            if(small == k){
                break;
            }
            
            swap(A, small, k);
            k = small;
        }
    }
    
    private void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}

