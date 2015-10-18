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
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
    ArrayList<TreeNode> ret = new ArrayList<TreeNode>();
    public void flatten(TreeNode root) {
        // write your code here
        if(root == null){
            return;
        }
        dfs(root);
        TreeNode cur = root;
        for(int i = 1; i < ret.size(); i++){
            cur.left = null;
            cur.right = ret.get(i);
            cur = cur.right;
        }
        cur.left = null;
        cur.right = null;
        
    }
    
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        ret.add(root);
        dfs(root.left);
        dfs(root.right);
    }
}
