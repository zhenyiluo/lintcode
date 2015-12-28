public class Solution {
    HashSet<Integer> hs = new HashSet<>();
    /**
     * @param n an integer
     * @return true if this is a happy number or false
     */
    public boolean isHappy(int n) {
        // Write your code here
        if(n <= 0){
            return false;
        }
        if(n == 1){
            return true;
        }
        if(hs.contains(n)){
            return false;
        }
        
        hs.add(n);
        
        String s = String.valueOf(n);
        int val = 0;
        for(int i = 0; i < s.length(); i++){
            int num = s.charAt(i) - '0';
            val += num * num;
        }
        return isHappy(val);
    }
}