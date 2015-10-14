class Solution {
    /**
     * @param A: An integer array.
     * @return: void
     */
    public void rerange(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return;
        }
        
        int len = A.length;
        boolean allPositive = true;
        boolean allNegative = true;
        int countP = 0;
        int countN = 0;
        for(int i = 0; i < len; i++){
            if(A[i] < 0){
                countN ++;
                allPositive = false;
            }else if(A[i] > 0){
                countP ++;
                allNegative = false;
            }
        }
        
        if(allPositive || allNegative){
            return;
        }
        int flag = 1;
        if(countP > countN){
            flag = -1;
        }
        shuffle(flag, A, len);
       
   }
   
   private void shuffle(int flag, int[] A, int len){
        int odd = 0;
        int even = 1;
        int index = 0;
        
        while(index < len){
            if(A[index] * flag < 0 && index % 2 != 0){
                swap(A, index, odd);
                odd += 2;
            }else if(A[index] * flag > 0 && index % 2 == 0){
                swap(A, index, even);
                even += 2;
            }else{
                index++;
            }
        }
   }
   
   private void swap(int[] A, int i, int j){
       int tmp = A[i];
       A[i] = A[j];
       A[j] = tmp;
   }
}
