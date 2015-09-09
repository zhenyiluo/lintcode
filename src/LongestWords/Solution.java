class Solution {
    /**
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     */
    ArrayList<String> longestWords(String[] dictionary) {
        // write your code here
        ArrayList<String> ret = new ArrayList<String>();
        int max = 0;
        for(String s : dictionary){
            int len = s.length();
            if(len < max){
                continue;
            }else if(len == max){
                ret.add(s);
            }else{
                ret.clear();
                max = len;
                ret.add(s);
            }
        }
        return ret;
    }
};
