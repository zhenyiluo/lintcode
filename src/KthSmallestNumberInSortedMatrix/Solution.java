public class Solution {
    static final int[] dx = {0, 1};
    static final int[] dy = {1, 0};
    /**
     * @param matrix: a matrix of integers
     * @param k: an integer
     * @return: the kth smallest number in the matrix
     */
    public int kthSmallest(int[][] matrix, int k) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int ret = 0; 
        PriorityQueue<Node> pq = new PriorityQueue<Node>(10, new Comparator<Node>(){
            @Override
            public int compare(Node node1, Node node2){
                return node1.val - node2.val;
            }
        });
        pq.add(new Node(0, 0, matrix[0][0]));
        visited[0][0] = true;
        for(int i = 0; i < k; i++){
            Node node = pq.poll();
            ret = node.val;
            int x = node.row;
            int y = node.col;
            for(int j = 0; j < 2; j++){
                int nx = x + dx[j];
                int ny = y + dy[j];
                if(nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]){
                    pq.add(new Node(nx, ny, matrix[nx][ny]));
                    visited[nx][ny] = true;
                }
            }
        }
        return ret;
    }
}

class Node{
    int row;
    int col;
    int val;
    public Node(int row, int col, int val){
        this.row = row;
        this.col = col;
        this.val = val;
    }
}