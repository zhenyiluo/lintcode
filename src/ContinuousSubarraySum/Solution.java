public class Solution {
    /**
     * @param A an integer array
     * @return  A list of integers includes the index of the first number and the index of the last number
     */
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
