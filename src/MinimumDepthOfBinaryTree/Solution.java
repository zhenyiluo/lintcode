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
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        Queue<Integer> qLevel = new LinkedList<Integer>();
        q.add(root);
        qLevel.add(1);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int level = qLevel.poll();
            if(node.left == null && node.right == null){
                return level;
            }
            
            if(node.left != null){
                q.add(node.left);
                qLevel.add(level+1);
            }
            
            if(node.right != null){
                q.add(node.right);
                qLevel.add(level+1);
            }
        }
        
        return -1;
    }
}


// another Solution

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
     * @param root: The root of binary tree.
     * @return: An integer.
     */
    public int minDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        
        if(root.left == null){
            return minDepth(root.right) + 1;
        }
        
        if(root.right == null){
            return minDepth(root.left) + 1;
        }
        
        return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
    }
}
