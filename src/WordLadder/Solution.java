public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        
        int count = 1;
        Queue<String> q = new LinkedList<>();
        Queue<Integer> lq = new LinkedList<>();
        q.add(start);
        lq.add(count);
        HashSet<String> hs = new HashSet<String>();
        hs.add(start);
        while(!q.isEmpty()){
            int level = lq.poll();
            String s = q.poll();
            if(s.equals(end)){
                return level;
            }
            StringBuilder sb = new StringBuilder(s);
            for(int i = 0; i < sb.length(); i++){
                char c = sb.charAt(i);
                for(char tmp = 'a'; tmp <= 'z'; tmp++){
                    if(tmp != c){
                        sb.setCharAt(i, tmp);
                        if(!hs.contains(sb.toString()) && dict.contains(sb.toString())){
                            hs.add(sb.toString());
                            q.add(sb.toString());
                            lq.add(level+1);
                        }
                    }
                }
                sb.setCharAt(i, c);
            }
        }
        return 0;
    }
}
