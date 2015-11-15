import java.util.*;

public class Solution1 {
    static int MaxVal = 10003;
    int[] tree;

    public ArrayList<Integer> countOfSmallerNumberII(int[] A) {
        int len = A.length;
        tree = new int[MaxVal];
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = 0; i < len; i ++){
            update(A[i]+1, 1);
            ret.add(read(A[i]));
        }
        return ret;
    }


    private void update(int idx, int val){
        while(idx <= MaxVal){
            tree[idx] += val;
            idx += (idx & -idx);
        }
    }

    private int read(int idx){
        int sum = 0;
        while(idx > 0){
            sum += tree[idx];
            idx -= (idx & -idx);
        }
        return sum;
    }
}


