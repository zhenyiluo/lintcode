public class Solution {
    /**
     * @param expression: A string array
     * @return: The Polish notation of this expression
     */
    public ArrayList<String> convertToPN(String[] expression) {
        // write your code here
        ArrayList<String> ret = new ArrayList<String>();
        if(expression == null || expression.length == 0){
            return ret;
        }
        Stack<String> nonOp = new Stack<String>();
        Stack<String> op = new Stack<String>();
        int len = expression.length;
        
        for(int i = 0; i < len; i++){
            String cur = expression[i];
            if(isOp(cur)){
                if(cur.equals("(")){
                    op.push(cur);
                }else{
                    if(cur.equals(")")){
                        while(!op.isEmpty()){
                            String tmp = op.pop();
                            if(tmp.equals("(")){
                                break;
                            }
                            String val2 = nonOp.pop();
                            String val1 = nonOp.pop();
                            nonOp.push(tmp + "#" + val1 + "#" + val2);
                        }
                    }else{
                        while(!op.isEmpty() && getOrder(op.peek()) >= getOrder(cur)){
                            String val2 = nonOp.pop();
                            String val1 = nonOp.pop();
                            nonOp.push(op.pop() + "#"  + val1 + "#"  + val2);
                        }
                        op.push(cur);
                    }
                }
            }else{
                nonOp.push(cur);
            }
        }
        
        while(!op.isEmpty()){
            String val2 = nonOp.pop();
            String val1 = nonOp.pop();
            nonOp.push(op.pop() + "#"  + val1 + "#"  + val2);
        }
        
        if(nonOp.size() == 1){
            String[] s = nonOp.pop().split("#");
            for(int i = 0; i < s.length; i++){
                ret.add(s[i]);
            }
        }
        
        return ret;
    }
    
    public boolean isOp(String s){
        if(s.equals("+") || s.equals("-")|| s.equals("*")|| s.equals("/")
        || s.equals("(") ||s.equals(")")){
            return true;
        }
        return false;
    }
    
    public int getOrder(String s){
        if(s.equals("*") || s.equals("/")){
            return 2;
        }else if(s.equals("+") || s.equals("-")){
            return 1;
        }else{
            return 0;
        }
    }
}


// Solution 2:

public class Solution {
    /**
     * @param expression: A string array
     * @return: The Polish notation of this expression
     */
    public ArrayList<String> convertToPN(String[] expression) {
        // write your code here
        ArrayList<String> ret = new ArrayList<String>();
        ArrayList<String> list = new ArrayList<String>();
        if(expression == null || expression.length == 0){
            return ret;
        }
        Stack<String> op = new Stack<String>();
        int len = expression.length;
        
        for(int i = len-1; i >= 0; i--){
            String cur = expression[i];
            if(isOp(cur)){
                if(cur.equals(")")){
                    op.push(cur);
                }else{
                    if(cur.equals("(")){
                        while(!op.isEmpty()){
                            String tmp = op.pop();
                            if(tmp.equals(")")){
                                break;
                            }
                            list.add(tmp);
                        }
                    }else{
                        while(!op.isEmpty() && getOrder(op.peek()) > getOrder(cur)){
                            list.add(op.pop());
                        }
                        op.push(cur);
                    }
                }
            }else{
                list.add(cur);
            }
        }
        
        while(!op.isEmpty()){
            list.add(op.pop());
        }
        
        for(int i = list.size()-1; i>= 0; i--){
            ret.add(list.get(i));
        }
        
        return ret;
    }
    
    public boolean isOp(String s){
        if(s.equals("+") || s.equals("-")|| s.equals("*")|| s.equals("/")
        || s.equals("(") ||s.equals(")")){
            return true;
        }
        return false;
    }
    
    public int getOrder(String s){
        if(s.equals("*") || s.equals("/")){
            return 2;
        }else if(s.equals("+") || s.equals("-")){
            return 1;
        }else{
            return 0;
        }
    }
}
