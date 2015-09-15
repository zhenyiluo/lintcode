import java.util.Arrays;

public class Solution {
    
    /**
     * @param s1 A string
     * @param s2 Another string
     * @return whether s2 is a scrambled string of s1
     */
    public boolean isScramble(String s1, String s2) {
        // Write your code here
        if(s1 == null || s2 == null){
            return false;
        }
        
        if(s1.length() != s2.length()){
            return false;
        }
        
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!Arrays.equals(c1, c2)){
            return false;
        }
        
        if(c1.length <= 1){
            return true;
        }
        
        for(int l1 = 1; l1 < c1.length; l1++){
            int l2 = c1.length - l1;
            String ss1 = s1.substring(0, l1);
            String ss2 = s2.substring(0, l1);
            String ss3 = s1.substring(l1);
            String ss4 = s2.substring(l1);
            String ss5 = s2.substring(l2);
            String ss6 = s2.substring(0, l2);
            if( (isScramble(ss1, ss2) && isScramble(ss3, ss4) ) 
            ||  (isScramble(ss1, ss5) && isScramble(ss3, ss6) ) ){
                return true;
            }
        }
        return false;
    }
}
