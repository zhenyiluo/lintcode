public class Solution {
    /**
     * @param expression: A string array
     * @return: The Reverse Polish notation of this expression
     */
    public ArrayList<String> convertToRPN(String[] expression) {
        // write your code here
        ArrayList<String> list = new ArrayList<String>();
        Stack<String> stack = new Stack<String>();
        
        int len = expression.length;
        for(int i = 0; i < len; i++){
            String s = expression[i];
            if(isOp(s)){
                if(s.equals("(")){
                    stack.push(s);
                }else if(s.equals(")")){
                    while(!stack.isEmpty()){
                        String tmp = stack.pop();
                        if(tmp.equals("(")){
                            break;
                        }
                        list.add(tmp);
                    }
                }else{
                    while(!stack.isEmpty() && getOrder(stack.peek())>=getOrder(s) ){
                        list.add(stack.pop());
                    }
                    stack.push(s);
                }
                
            }else{
                list.add(s);
            }
        }
        
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        return list;
    }
    
    public boolean isOp(String s){
        if(s.equals("(") || s.equals(")") || s.equals("+") || s.equals("-") 
        || s.equals("*") || s.equals("/")){
            return true;
        }else{
            return false;
        }
    }
    
    public int getOrder(String s){
        if(s.equals("+") || s.equals("-")){
            return 1;
        }
        
        if(s.equals("*") || s.equals("/")){
            return 2;
        }
        
        return 0;
    }
}
