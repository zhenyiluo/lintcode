/**
 * Definition for a point.
 * struct Point {
 *     int x;
 *     int y;
 *     Point() : x(0), y(0) {}
 *     Point(int a, int b) : x(a), y(b) {}
 * };
 */
public class Solution {

    private int findFather(HashMap<Integer, Integer> father, int x) {
        if (father.contains(x)) {
            father.put(x, x);
            return x;
        }
        int res = x, tmp;
        while (res != father.get(res)) {
            res = father.get(res);
        }
        while (x != father.get(x)) {
            tmp = father.get(x);
            father.put(x, res);
            x = tmp;
        }
        return x;
    }
    public static final int dx[] = {0, 1, 0, -1};
    public static final int dy[] = {1, 0, -1, 0};
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // Write your code here
        HashMap<Integer, Integer> father;
        List<Integer> res = new ArrayList<Integer>();
        int cnt = 0;
        for (Point op : operators) {
            int p = op.x * m + op.y;
            int fp = findFather(father, p);
            if (fp == p) ++cnt;
            for (int i = 0; i < 4; ++i) {
                int xx = op.x + dx[i], yy = op.y + dy[i];
                if (xx < 0 || xx >= n || yy < 0 || yy >= m) continue;
                int q = (op.x + dx[i]) * m + op.y + dy[i];
                if (father.find(q) != father.end()) {
                    int fq = findFather(father, q);
                    if (fp != fq) {
                        --cnt;
                        father.put(fq, fp);
                    }
                }
            }
            res.add(cnt);
        }
        return res;
    }
}