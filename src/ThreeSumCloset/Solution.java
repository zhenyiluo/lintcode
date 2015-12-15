public class Solution {
    /**
     * @param numbers: Give an array numbers of n integer
     * @param target : An integer
     * @return : return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers ,int target) {
        // write your code here
        Arrays.sort(numbers);
        int min = Integer.MAX_VALUE;
        int ret = 0;
        int len = numbers.length;
        for(int i = 0; i < len-2; i++){
            int j = i + 1;
            int k = len - 1;
            while(j < k){
                int sum = numbers[i] + numbers[j] + numbers[k];
                int diff = Math.abs(target - sum);
                if(diff < min){
                    min = diff;
                    ret = sum;
                }
                if(sum == target){
                    return sum;
                }else if(sum < target){
                    j ++;
                }else{
                    k --;
                }
            }
        }
        
        return ret;
    }
}
