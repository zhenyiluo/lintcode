public class Solution {
    /* you may need to use some attributes here */
    

    /**
     * @param A: An integer array
     */
    int[] A;
    SegmentTree root;
    public Solution(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            root = null;
        }else{
            this.A = A;
            int len = A.length;
        
            root = new SegmentTree(0, len-1);
        }
        
    }
    
    /**
     * @param start, end: Indices
     * @return: The sum from start to end
     */
    public long query(int start, int end) {
        // write your code here
        return root.query(start, end);
    }
    
    /**
     * @param index, value: modify A[index] to value.
     */
    public void modify(int index, int value) {
        // write your code here
        root.update(index, value);
    }
    
    class SegmentTree{
        SegmentTree left, right;
        int start, end;
        long sum;
        public SegmentTree(int start, int end){
            this.start = start;
            this.end = end;
            if(start == end){
                sum = A[start];
            }else{
                int mid = start + ((end - start) >> 1);
                this.left = new SegmentTree(start, mid);
                this.right = new SegmentTree(mid+1, end);
                this.sum = this.left.sum + this.right.sum;
            }
        }
        
        public long query(int start, int end){
            if (start <= this.start && end >= this.end){
                return this.sum;
            }
            
            int mid = this.start + ((this.end - this.start)>>1);
            if(mid >= end){
                return this.left.query(start, end);
            }else if(mid < start){
                return this.right.query(start, end);
            }else{
                return this.left.query(start, mid) + this.right.query(mid+1, end);
            }
        }
        
        public void update(int pos, int val){
            if(this.start == pos && this.end == pos){
                this.sum = val;
                return;
            }
            
            int mid = this.start + ((this.end - this.start)>>1);
            if(mid >= pos){
                this.left.update(pos, val);
            }else{
                this.right.update(pos, val);
            }
            this.sum = this.left.sum + this.right.sum;
        }
    }
}

