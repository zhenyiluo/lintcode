public class Solution {
    /**
     * @param s Roman representation
     * @return an integer
     */
    public int romanToInt(String s) {
        // Write your code here
        int ret = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(i != 0 && helper(c) > helper(s.charAt(i-1))){
                ret += helper(c) - 2 * helper(s.charAt(i-1));
            }else{
                ret += helper(c);
            }
        }
        return ret;
    }
    
    private int helper(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default : return 0;
        }
    }
}
