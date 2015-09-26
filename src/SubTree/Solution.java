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
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if(T2 == null){
            return true;
        }else if(T1 == null){
            return false;
        }else return isSameTree(T1, T2) || isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }
    
    public boolean isSameTree(TreeNode t1, TreeNode t2){
        if(t1 == null && t2 == null){
            return true;
        }
        
        if(t1 == null || t2 == null){
            return false;
        }
        if(t1.val != t2.val){
            return false;
        }else{
            return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);
        }
    }
}
