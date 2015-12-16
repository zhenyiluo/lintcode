public class Solution {
    /**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        // write your code here
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        HashSet<ArrayList<Integer>> hs = new HashSet<>();
        
        if(numbers == null || numbers.length < 3){
            return ret;
        }
        
        Arrays.sort(numbers);
        int len = numbers.length;
        
        for(int i = 0; i < len; i++){
            int j = i + 1;
            int k = len - 1;
            while(j < k){
                int sum = numbers[i] + numbers[j] + numbers[k];
                if(sum == 0){
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(numbers[i]);
                    list.add(numbers[j]);
                    list.add(numbers[k]);
                    if(!hs.contains(list)){
                        hs.add(list);
                        ret.add(list);
                    }
                    j++;
                    k--;
                }else if(sum > 0){
                    k--;
                }else{
                    j++;
                }
            }
        }
        
        return ret;
    }
}