public class Solution {
    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if(gas == null || cost == null || gas.length != cost.length){
            return -1;
        }
                
        int sum = 0;
        int total = 0;
        int len = gas.length;
        int index = 0;
        for(int i = 0; i < len; i++){
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if(sum < 0){
                sum = 0;
                index = i+1;
            }
        }
        if(total < 0){
            return -1;
        }
        return index;
    }
}
