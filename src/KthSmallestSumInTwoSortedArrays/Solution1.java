import java.util.*;
public class Solution1 {
    /**
     * @param A an integer arrays sorted in ascending order
     * @param B an integer arrays sorted in ascending order
     * @param k an integer
     * @return an integer
     */
    public int kthSmallestSum(int[] A, int[] B, int k) {
        // Write your code here
        int lenA = A.length;
        int lenB = B.length;

        if(k <= 0){
            return 0;
        }

        HashSet<Integer> visited = new HashSet<>();

        PriorityQueue<Element> pq = new PriorityQueue<>(10, new Comparator<Element>(){
            @Override
            public int compare(Element e1, Element e2){
                if(e1.sum == e2.sum){
                    return e1.index - e2.index;
                }
                return e1.sum - e2.sum;
            }
        });
        pq.add(new Element(0, A[0] + B[0]));
        visited.add(0);
        int ret = 0;
        while(k > 0){
            Element e = pq.poll();
            ret = e.sum;
            int index = e.index;
            int row = index / lenA;
            int col = index % lenA;
            int index1 = (row+1) * lenA + col;
            if(row+1 < lenB && !visited.contains(index1)){
                pq.add(new Element(index1, A[col]+B[row+1]));
                visited.add(index1);
            }
            int index2 = row * lenA + (col + 1);
            if(col + 1 < lenA && !visited.contains(index2)){
                pq.add(new Element(index2, A[col + 1] + B[row]));
                visited.add(index2);
            }
            k--;
        }
        return ret;
    }
}

class Element{
    int index;
    int sum;
    public Element(int index, int sum){
        this.index = index;
        this.sum = sum;
    }
}