/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     * @param A: Given an integer array with no duplicates.
     * @return: The root of max tree.
     */
    public TreeNode maxTree(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return null;
        }
        Stack<TreeNode> st = new Stack<TreeNode>();
        for(int i = 0; i < A.length; i++){
            TreeNode cur = new TreeNode(A[i]);
            while(!st.isEmpty() && cur.val > st.peek().val){
                cur.left = st.pop();
            }
            if(!st.isEmpty()){
                st.peek().right = cur;
            }
            st.push(cur);
        }
        
        TreeNode ret = null;
        while(!st.isEmpty()){
            ret = st.pop();
        }
        return ret;
    }
}
