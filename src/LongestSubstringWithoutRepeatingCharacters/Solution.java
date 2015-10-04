public class Solution {
    /**
     * @param s: a string
     * @return: an integer 
     */
    public int lengthOfLongestSubstring(String s) {
        // write your code here
        if(s == null || s.length() == 0){
            return 0;
        }
        
        if(s.length() == 1){
            return 1;
        }
        
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
        int start = 0;
        int ret = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(hm.containsKey(c) && hm.get(c) >= start){
                ret = Math.max(ret, i - start);
                start = hm.get(c) + 1;
            }
            hm.put(c, i);
        }
        ret = Math.max(ret, s.length() - start);
        return ret;
    }
}
