public class Solution {
    /**
     * @param numbers : Give an array numbersbers of n integer
     * @param target : you need to find four elements that's sum of target
     * @return : Find all unique quadruplets in the array which gives the sum of
     *           zero.
     */
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        /* your code */
        HashSet<ArrayList<Integer>> hs = new HashSet<>();
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        if(numbers == null || numbers.length < 4){
            return ret;
        }
        
        int len = numbers.length;
        Arrays.sort(numbers);
        
        for(int i = 0; i < len -3; i++){
            for(int j = i+1; j < len -2; j++){
                int k = j + 1;
                int l = len - 1;
                while(k < l){
                    int sum = numbers[i] + numbers[j] + numbers[k] + numbers[l];
                    if(sum == target){
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[k]);
                        list.add(numbers[l]);
                        if(!hs.contains(list)){
                            hs.add(list);
                            ret.add(list);
                        }
                        k++;
                        l--;
                    }else if(sum < target){
                        k ++;
                    }else{
                        l --;
                    }
                }
            }
        }
        return ret;
    }
}