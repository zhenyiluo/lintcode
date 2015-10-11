public class Solution {
    /**
     * @param s: A string 
     * @param p: A string includes "?" and "*"
     * @return: A boolean
     */
    public boolean isMatch(String s, String p) {
        // write your code here
        int indexS = 0;
        int indexP = 0;
        int match = 0;
        int startIndex = -1;
        while(indexS < s.length()){
            if(indexP < p.length() && (s.charAt(indexS) == p.charAt(indexP) || p.charAt(indexP) == '?')){
                indexS ++;
                indexP ++;
            }else if(indexP < p.length() && p.charAt(indexP) == '*'){
                startIndex = indexP;
                match = indexS;
                indexP++;
            }else if(startIndex != -1){
                match ++;
                indexS = match;
                indexP = startIndex + 1;
            }else{
                return false;
            }
        }
        
        while(indexP < p.length() && p.charAt(indexP) == '*'){
            indexP++;
        }
        return indexP == p.length();
     }
}
