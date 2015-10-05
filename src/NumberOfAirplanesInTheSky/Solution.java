/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
        if(airplanes == null || airplanes.size() == 0){
            return 0;
        }
        int size = airplanes.size();
        Point[] points = new Point[2 * size];        
        for(int i = 0; i < size; i++){
            points[2 * i] = new Point(airplanes.get(i).start, 1);
            points[2 * i + 1] = new Point(airplanes.get(i).end, -1);
        }
        
        Arrays.sort(points, new Comparator<Point>(){
            @Override
            public int compare(Point p1, Point p2){
                if(p1.startTime != p2.startTime){
                    return p1.startTime - p2.startTime;
                }
                return p1.isStart - p2.isStart;
            }
        });
        
        int ret = 0;
        int cnt = 0;
        for(int i = 0; i < 2 * size; i++){
            if(points[i].isStart == 1){
                cnt ++;
                ret = Math.max(ret, cnt);
            }else{
                cnt --;
            }
        }
        return ret;
    }
    
    static class Point{
        int startTime;
        int isStart;
        public Point(int startTime, int isStart){
            this.startTime = startTime;
            this.isStart = isStart;
        }
    }
}
