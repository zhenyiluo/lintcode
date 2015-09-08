/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class Solution {
    /**
     * @param points an array of point
     * @return an integer
     */
    public int maxPoints(Point[] points) {
        // Write your code here
        if(points == null || points.length == 0){
            return 0;
        }
        
        if(points.length == 1){
            return 1;
        }
        int ret = 0;
        int n = points.length;
        for(int i = 0; i < n-1; i++){
            Point p1 = points[i];
            int same = 1;
            HashMap<Double, Integer> hm = new HashMap<Double, Integer>();
            for(int j = 0; j < n; j++){
                if(i == j){
                    continue;
                }
                Point p2 = points[j];
                if(p1.x == p2.x && p1.y == p2.y){
                    same ++;
                    continue;
                }
                double k = (p2.x == p1.x)? Double.MAX_VALUE : (double)(p2.y - p1.y)/(p2.x - p1.x);
                
                if(hm.containsKey(k)){
                    hm.put(k, hm.get(k) + 1);
                }else{
                    hm.put(k, 1);
                }
            }
            int tmp = 0;
            for(Integer num : hm.values()){
                tmp = Math.max(tmp, num);
            }
            ret = Math.max(tmp+same, ret);
        }
        return ret;
    }
}