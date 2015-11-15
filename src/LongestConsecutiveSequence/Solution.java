public class Solution {
    /**
     * @param nums: A list of integers
     * @return an integer
     */
    public int longestConsecutive(int[] num) {
        // write you code here
        if(num == null || num.length == 0){
            return 0;
        }
        
        int max = 0;
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < num.length; i++){
            hs.add(num[i]);
        }
        
        for(int i = 0; i < num.length; i++){
            if(hs.contains(num[i])){
                int count = 1;
                int left = num[i]-1;
                int right = num[i]+1;
                while(hs.contains(left)){
                    hs.remove(left);
                    left --;
                    count++;
                }
                while(hs.contains(right)){
                    hs.remove(right);
                    right ++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
