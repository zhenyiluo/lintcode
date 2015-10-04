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
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {  
        // write your code here
        if(A == null || A.length == 0){
            return null;
        }
        return sortedArrayToBST(A, 0, A.length -1);
    }  
    
    private TreeNode sortedArrayToBST(int[] A, int start, int end){
        if(start > end){
            return null;
        }
        int mid = start + ((end - start) >> 1);
        TreeNode root = new TreeNode(A[mid]);
        root.left = sortedArrayToBST(A, start, mid-1);
        root.right = sortedArrayToBST(A, mid+1, end);
        return root;
    }
}

