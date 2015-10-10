public class Solution {
    /**
     * @param heights: a matrix of integers
     * @return: an integer
     */
    public int trapRainWater(int[][] heights) {
        // write your code here
        if(heights == null || heights.length < 3 || heights[0].length < 3){
            return 0;
        }
        
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<Element> minHeap = new PriorityQueue<Element>(10, new Comparator<Element>(){
            @Override 
            public int compare(Element e1, Element e2){
                return e1.h - e2.h;
            }
        });
        
        for(int i = 0; i < m; i++){
            minHeap.add(new Element(i, 0, heights[i][0]));
            minHeap.add(new Element(i, n-1, heights[i][n-1]));
        }
        
        for(int j = 1; j < n-1; j++){
            minHeap.add(new Element(0, j, heights[0][j]));
            minHeap.add(new Element(m-1, j, heights[m-1][j]));
        }
        int ret = 0;
        while(!minHeap.isEmpty()){
            Element elem = minHeap.poll();
            int x = elem.x;
            int y = elem.y;
            int h = elem.h;
            visited[x][y] = true;
            for(int i = 0; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >= 0 && ny >= 0 && nx <m && ny < n && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    int nh = heights[nx][ny];
                    ret += Math.max(0, h - nh);
                    minHeap.add(new Element(nx, ny, Math.max(h, nh)));
                }
            }
        }
        return ret;
    }
    
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    static class Element{
        int x;
        int y;
        int h;
        public Element(int x, int y, int h){
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
};
