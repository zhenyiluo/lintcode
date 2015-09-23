public class Solution {
    /**
     * @param n The integer
     * @return Roman representation
     */
    public String intToRoman(int n) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        hm.put(1000, "M");
        hm.put(900, "CM");
        hm.put(500, "D");
        hm.put(400, "CD");
        hm.put(100, "C");
        hm.put(90, "XC");
        hm.put(50, "L");
        hm.put(40, "XL");
        hm.put(10, "X");
        hm.put(9, "IX");
        hm.put(5, "V");
        hm.put(4, "IV");
        hm.put(1, "I");
        int[] nums = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        while(n > 0){
            for(int i = 0; i < nums.length; i++){
                if(n >= nums[i]){
                    sb.append(hm.get(nums[i]));
                    n -= nums[i];
                    break;
                }
            }
        }
        return sb.toString();
    }
}
