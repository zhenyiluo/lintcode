public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        List<String> ret = new LinkedList<String>();
        if(strs == null || strs.length < 2){
            return ret;
        }
        HashMap<String, List<String>> hm = new HashMap<String, List<String>>();
        for(int i = 0; i < strs.length; i++){
            String s = strs[i];
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(hm.containsKey(key)){
                List<String> tmp = hm.get(key);
                tmp.add(s);
            }else{
                List<String> tmp = new LinkedList<String>();
                tmp.add(s);
                hm.put(key, tmp);                
            }
        }
        
        for(String key: hm.keySet()){
            if(hm.get(key).size() > 1){
                for(String ss : hm.get(key)){
                    ret.add(ss);
                }
            }
        }
        return ret;
    }
}
