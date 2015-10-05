public class Solution {
    /**
     * @param s : A string
     * @return : The length of the longest substring 
     *           that contains at most k distinct characters.
     */
     HashMap<Character, Integer> hm;
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        // write your code here
        if(s == null || s.length() == 0 || k <= 0){
            return 0;
        }
        
        int ret = 0;
        int start = 0;
        hm = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!hm.containsKey(c)){
                hm.put(c, 1);
                if(hm.size() > k){
                    ret = Math.max(ret, i - start);
                    start = shrink(s, start);
                } 
            }else{
                hm.put(c, hm.get(c)+1);
            }
        }
        ret = Math.max(ret, s.length() - start);
        
        return ret;
    }
    
    private int shrink(String s, int start){
        while(true){
            char c = s.charAt(start);
            if(hm.get(c) == 1){
                hm.remove(c);
                return start+1;
            }else{
                hm.put(c, hm.get(c) -1);
            }
            start++;
        }
    }
}
