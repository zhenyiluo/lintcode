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
    public ArrayList<Long> intervalSum(int[] A, 
                                       ArrayList<Interval> queries) {
        // write your code here
        this.A = A;
        int len = A.length;
        SegmentTree root = new SegmentTree(0, len-1);
        ArrayList<Long> ret = new ArrayList<Long>();
        for(Interval query : queries){
            ret.add(root.query(query.start, query.end));
        }
        return ret;
    }
    
    
class SegmentTree{
    SegmentTree left, right;
    int start, end;
    long sum;
    public SegmentTree(int start, int end){
        this.start = start;
        this.end = end;
        if(start == end){
            this.sum = A[start];
        }else{
            int mid = start + ((end - start)>>1);
            this.left = new SegmentTree(start, mid);
            this.right = new SegmentTree(mid+1, end);
            this.sum = this.left.sum + this.right.sum;
        }
    }
    
    public long query(int start, int end){
        if(start <= this.start && end >= this.end){
            return sum;
        }
        int mid = this.start + ((this.end - this.start) >> 1);
        if(mid >= end){
            return this.left.query(start, end);
        }else if(mid < start){
            return this.right.query(start, end);
        }else{
            return this.left.query(start, mid) + this.right.query(mid+1, end);
        }
    }
}

}

