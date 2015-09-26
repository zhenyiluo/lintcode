/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: Sorted interval list.
     * @return: A new sorted interval list.
     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> ret = new ArrayList<Interval>();
        if(intervals == null || intervals.isEmpty()){
            return ret;
        }
        
        if(intervals.size() == 1){
            ret.add(intervals.get(0));
            return ret;
        }
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2){
                if(i1.start != i2.start){
                    return i1.start - i2.start;
                }else{
                    return i1.end - i2.end;
                }
            }
        });
        
        Interval pre = intervals.get(0);
        for(int i =1; i < intervals.size(); i++){
            Interval cur = intervals.get(i);
            if(pre.end >= cur.start){
                pre.end = Math.max(pre.end, cur.end);
            }else{
                ret.add(pre);
                pre = cur;
            }
        }
        ret.add(pre);
        return ret;
    }
}
