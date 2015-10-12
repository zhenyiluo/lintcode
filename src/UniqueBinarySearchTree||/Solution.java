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
     * @paramn n: An integer
     * @return: A list of root
     */
    public List<TreeNode> generateTrees(int n) {
        // write your code here
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int start, int end){
        List<TreeNode> list = new LinkedList<TreeNode>();
        if(start > end){
            list.add(null);
            return list;
        }
        
        for(int i = start; i <= end; i++){
            List<TreeNode> left = generateTrees(start, i-1);
            List<TreeNode> right = generateTrees(i+1, end);
            for(TreeNode l : left){
                for(TreeNode r : right){
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    list.add(root);
                }
            }
        }
        return list;
    }
}
