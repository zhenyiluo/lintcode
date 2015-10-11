public class Solution {
    /**
     *@param num: A list of non negative integers
     *@return: A string
     */
    public String largestNumber(int[] num) {
        // write your code here
        if(num == null || num.length == 0){
            return "";
        }
        int len = num.length;
        String[] nums = new String[len];
        for(int i = 0; i < len; i++){
            nums[i] = String.valueOf(num[i]);
        }
        
        Arrays.sort(nums, new Comparator<String>(){
            @Override 
            public int compare(String s1, String s2){
                return (s1+s2).compareTo(s2+s1);
            }
        });
        
        StringBuilder sb = new StringBuilder();
        for(int i = len-1; i >= 0; i--){
            sb.append(nums[i]);
        }
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
