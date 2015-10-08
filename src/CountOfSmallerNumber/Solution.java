public class Solution {
   /**
     * @param A: An integer array
     * @return: The number of element in the array that 
     *          are smaller that the given integer
     */
    int[] nums = new int[10001];
    public ArrayList<Integer> countOfSmallerNumber(int[] A, int[] queries) {
          // write your code here
        
        ArrayList<Integer> ret = new ArrayList<Integer>();
        for(int i = 0; i < A.length; i++){
            nums[A[i]]++;
        }
        SegmentTree root = build(0, 10000);
        for(int i = 0; i < queries.length; i++){
            int n = queries[i];
            if(n == 0){
                ret.add(0);
            }else{
                ret.add(query(root, 0, n-1));
            }
        }
        return ret;
    }
    public SegmentTree build(int start, int end){
        if(start > end){
            return null;
        }
        SegmentTree root = new SegmentTree(start, end);
        if(start == end){
            root.count = nums[start];
            return root;
        }
        int mid = start + ((end - start) >> 1);
        root.left = build(start, mid);
        root.right = build(mid+1, end);
        root.count = root.left.count + root.right.count;
        return root;
    }
    
    public int query(SegmentTree root, int start, int end){
        if(root == null || start > root.end || end < root.start){
            return 0;
        }
        if(start <= root.start && end >= root.end){
            return root.count;
        }
        int mid = root.start + ((root.end - root.start) >>1);
        if(mid >= end){
            return query(root.left, start, end);
        }else if(mid < start){
            return query(root.right, start, end);
        }else{
            return query(root.left, start, mid) + query(root.right, mid+1, end);
        }
    }
    
}

class SegmentTree{
    int start;
    int end;
    int count;
    SegmentTree left, right;
    public SegmentTree(int start, int end){
        this.start = start;
        this.end = end;
    }
}

