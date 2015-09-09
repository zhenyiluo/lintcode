/**
 * Definition of SegmentTreeNode:
 * public class SegmentTreeNode {
 *     public int start, end, max;
 *     public SegmentTreeNode left, right;
 *     public SegmentTreeNode(int start, int end, int max) {
 *         this.start = start;
 *         this.end = end;
 *         this.max = max
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution {
    /**
     *@param A: a list of integer
     *@return: The root of Segment Tree
     */
    public SegmentTreeNode build(int[] A) {
        if(A == null || A.length == 0){
            return null;
        }
        // write your code here
        return build(A, 0, A.length-1);
    }
    
    private SegmentTreeNode build(int[] A, int start, int end){
        if(start == end){
            return new SegmentTreeNode(start, end, A[start]);
        }
        int mid = start + ((end - start) >> 1);
        SegmentTreeNode left = build(A, start, mid);
        SegmentTreeNode right = build(A, mid+1, end);
        int max = Math.max(left.max, right.max);
        SegmentTreeNode cur =  new SegmentTreeNode(start, end, max);
        cur.left = left; 
        cur.right = right;
        return cur;
    }
}
