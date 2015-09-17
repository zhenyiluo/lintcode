public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
    public ArrayList<Integer> continuousSubarraySumII(int[] A) {
        // Write your code here
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(A == null || A.length == 0){
            return ret;
        }
        
        int len = A.length;
        
        boolean allNegative = true;
        for(int i = 0; i < len; i++){
            if(A[i] >= 0){
                allNegative = false;
                break;
            }
        }
        if(allNegative){
            int max = Integer.MIN_VALUE;
            int lr = 0;
            for(int i = 0; i < len; i++){
                if(A[i] > max){
                    A[i] = max;
                    lr = i;
                }
            }
            ret.add(lr);
            ret.add(lr);
            return ret;
        }
        
        int sum = 0;
        for(int i = 0; i < len; i++){
            sum += A[i];
        }
        int[] B = new int[len];
        for(int i = 0; i <len; i++){
            B[i] = - A[i];
        }
        
        ArrayList<Integer> list1 = continuousSubarraySum(A);
        ArrayList<Integer> list2 = continuousSubarraySum(B);
        
        int left = list1.get(0);
        int right = list1.get(1);
        int sum1 = 0;
        for(int i = left ; i <= right; i++){
            sum1 += A[i];
        }
        
        left = list2.get(0);
        right = list2.get(1);
        int sum2 = 0;
        for(int i = left ; i <= right; i++){
            sum2 += A[i];
        }
        int tmp = sum - sum2;
        
        if(sum1 > tmp){
            return list1;
        }else{
            ArrayList<Integer> list3 = new ArrayList<Integer>();
            list3.add((list2.get(1) + 1) % len);
            list3.add((list2.get(0) - 1) % len);
            return list3;
        }
    }
    
       public ArrayList<Integer> continuousSubarraySum(int[] A) {
        // Write your code here
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(A == null || A.length == 0){
            return ret;
        }
        
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int len = A.length;
        int left = 0; 
        int right = 0;
        int tmp = 0;
        for(int i = 0; i < len; i++){
            sum += A[i];
            if(sum > max){
                max = sum;
                right = i;
                left = tmp;
            }
            if(sum < 0){
                sum = 0;
                tmp = i + 1;
            }
        }
        ret.add(left);
        ret.add(right);
        return ret;
    }
}
