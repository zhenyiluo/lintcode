import java.util.*;
public class Solution {
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

        TreeSet<Element> treeSet = new TreeSet<>();
        treeSet.add(new Element(0, A[0] + B[0]));

        int ret = 0;
        while(k > 0){
            Element e = treeSet.pollFirst();
            ret = e.sum;
            int index = e.index;
            int row = index / lenA;
            int col = index % lenA;
            int index1 = (row+1) * lenA + col;
            if(row+1 < lenB ){
                treeSet.add(new Element(index1, A[col]+B[row+1]));
            }
            int index2 = row * lenA + (col + 1);
            if(col + 1 < lenA ){
                treeSet.add(new Element(index2, A[col + 1] + B[row]));
            }
            k--;
        }
        return ret;
    }
}

class Element implements Comparable<Element>{
    int index;
    int sum;
    public Element(int index, int sum){
        this.index = index;
        this.sum = sum;
    }

    @Override
    public int compareTo(Element another) {
        if(this.sum != another.sum){
            return this.sum - another.sum;
        }
        return this.index - another.index;
    }

    @Override
    public int hashCode(){
        return index;
    }

    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof Element)){
            return false;
        }

        if( ((Element)obj).index == this.index){
            return true;
        }
        return false;
    }
}