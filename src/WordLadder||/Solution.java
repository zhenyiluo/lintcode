public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return a list of lists of string
      */
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here  
        List<List<String>> ret = new ArrayList<>();
        dict.add(end);
        
        Queue<Element> q = new LinkedList<>();
        q.add(new Element(1, null, start));
        HashSet<String> visited = new HashSet<>();
        HashSet<String> unVisited = new HashSet<>(dict);
        int min = 0;
        int pre = 0;
        while(!q.isEmpty()){
            Element e = q.poll();
            int cur = e.step;
            String curStr = e.str;
            
            if(curStr.equals(end)){
                if(min == 0){
                    min = cur;
                }
                
                if(min != 0 && cur == min){
                    ArrayList<String> list = new ArrayList<>();
                    list.add(e.str);
                    while(e.pre != null){
                        e = e.pre;
                        list.add(0, e.str);
                    }
                    ret.add(list);
                }
                
                continue;
            }
            
            if(pre < cur){
                unVisited.removeAll(visited);
            }
            pre = cur;
            
            char[] chArr = curStr.toCharArray();
            for(int i = 0; i < chArr.length; i++){
                char tmp = chArr[i];
                for(char c = 'a'; c <= 'z'; c++){
                    if(c != tmp){
                        chArr[i] = c;
                        String s = new String(chArr);
                        if(unVisited.contains(s)){
                            visited.add(s);
                            q.add(new Element(cur+1, e, s));
                        }
                    }
                }
                chArr[i] = tmp;
            }
        }
        return ret;
    }
    
}

class Element{
    int step;
    Element pre;
    String str;
    public Element(int step, Element pre, String str){
        this.step = step;
        this.pre = pre;
        this.str = str;
    }
}
