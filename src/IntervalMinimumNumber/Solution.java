/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */
public class Solution {
    /**
     *@param A, queries: Given an integer array and an query list
     *@return: The result list
     */
     int[] A;
    public ArrayList<Integer> intervalMinNumber(int[] A, 
                                                ArrayList<Interval> queries) {
        // write your code here
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(A == null || A.length == 0 || queries == null){
            return ret;
        }
        int len = A.length;
        this.A = A;
        SegmentTree root = new SegmentTree(0, len-1);
        for(Interval query : queries){
            ret.add(root.query(query.start, query.end));
        }
        return ret;
    }
    
    class SegmentTree{
        SegmentTree left, right;
        int start, end;
        int min;
        public SegmentTree(int start, int end){
            this.start = start;
            this.end = end;
            if(start == end){
                this.min = A[start];
            }else{
                int mid = start + ((end - start)>>1);
                this.left = new SegmentTree(start, mid);
                this.right = new SegmentTree(mid+1, end);
                this.min = Math.min(this.left.min, this.right.min);
            }
        }
        
        public int query(int start, int end){
            if(start <= this.start && end >= this.end){
                return this.min;
            }
            
            int mid = this.start + ((this.end - this.start)>>1);
            if(mid >= end){
                return this.left.query(start, end);
            }else if(mid < start){
                return this.right.query(start, end);
            }else{
                return Math.min(this.left.query(start, mid), this.right.query(mid+1, end));
            }
        }
    }
}
