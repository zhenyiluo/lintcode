/**
 * Definition of ExpressionTreeNode:
 * public class ExpressionTreeNode {
 *     public String symbol;
 *     public ExpressionTreeNode left, right;
 *     public ExpressionTreeNode(String symbol) {
 *         this.symbol = symbol;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    
    public int get(String s, int base){
        if(s.equals("+") || s.equals("-")){
            return base + 1;
        }
        
        if(s.equals("*") || s.equals("/")){
            return base + 2;
        }
        
        return Integer.MAX_VALUE;
    }
    /**
     * @param expression: A string array
     * @return: The root of expression tree
     */
    public ExpressionTreeNode build(String[] expression) {
        // write your code here
        
        if(expression == null || expression.length == 0){
            return null;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = null;
        int val = 0;
        int base = 0;
        int len = expression.length;
        for(int i = 0; i <= len; i++){
            if(i != len){
                String s = expression[i];
                if(s.equals("(")){
                    base += 10;
                    continue;
                }
                
                if(s.equals(")")){
                    base -= 10;
                    continue;
                }
                
                val = get(s, base);
            }
            
            TreeNode right = i == len? new TreeNode(Integer.MIN_VALUE, "") :
            new TreeNode(val, expression[i]);
            
            while(!stack.isEmpty()){
                if(right.val <= stack.peek().val){
                    TreeNode now = stack.pop();
                    if(stack.isEmpty()){
                        right.root.left = now.root;
                    }else{
                        TreeNode left = stack.peek();
                        if(left.val < right.val){
                            right.root.left = now.root;
                        }else{
                            left.root.right = now.root;
                        }
                    }
                }else{
                    break;
                }
            }
            stack.push(right);
        }
        return stack.peek().root.left;
    }
}

class TreeNode{
    int val;
    ExpressionTreeNode root;
    public TreeNode(int val, String s){
        this.val = val;
        this.root = new ExpressionTreeNode(s);
    }
}
