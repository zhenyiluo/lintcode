import java.util.Stack;

public class Solution {
    /**
     * @param expression: an array of strings;
     * @return: an integer
     */
    public int evaluateExpression(String[] expression) {
        // write your code here
        if(expression == null || expression.length == 0){
            return 0;
        }
        
        int len = expression.length;
        Stack<Integer> stNum = new Stack<Integer>();
        Stack<String> stOp = new Stack<String>();
        for(int i = 0; i < len; i++){
            String s = expression[i];
            if(isOp(s)){
                if(s.equals("(")){
                    stOp.push(s);
                    continue;
                }else{
                    if(s.equals(")")){
                        while(!stOp.isEmpty()){
                            String tmp = stOp.pop();
                            if(tmp.equals("(")){
                                break;
                            }else{
                                int val2 = stNum.pop();
                                int val1 = stNum.pop();
                                stNum.push(eval(val1, val2, tmp));
                            }
                        }
                    }else{
                        while(!stOp.isEmpty() && getOrder(stOp.peek()) >= getOrder(s)){
                            int val2 = stNum.pop();
                            int val1 = stNum.pop();
                            String tmp = stOp.pop();
                            stNum.push(eval(val1, val2, tmp));
                        } 
                        stOp.push(s);
                    }
                }
            }else{
                stNum.push(Integer.valueOf(s));
            }
        }
        while(!stOp.isEmpty()){
            int val2 = stNum.pop();
            int val1 = stNum.pop();
            String tmp = stOp.pop();
            stNum.push(eval(val1, val2, tmp));
        }
        return stNum.isEmpty()? 0 : stNum.pop();
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
    
    public boolean isOp(String s){
        if(s.equals("+") || s.equals("-") || s.equals("*")
        || s.equals("/") || s.equals("(") || s.equals(")")){
            return true;
        }
        return false;
    }
    
    public int eval(int val1, int val2, String s){
        if(s.equals("+")){
            return val1 + val2;
        }else if(s.equals("-")){
            return val1 - val2;
        }else if(s.equals("*")){
            return val1 * val2;
        }else{
            return val1 / val2;
        }
    }
};
