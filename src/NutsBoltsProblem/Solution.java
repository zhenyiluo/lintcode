/**
 * public class NBCompare {
 *     public int cmp(String a, String b);
 * }
 * You can use compare.cmp(a, b) to compare nuts "a" and bolts "b",
 * if "a" is bigger than "b", it will return 1, else if they are equal,
 * it will return 0, else if "a" is smaller than "b", it will return -1.
 * When "a" is not a nut or "b" is not a bolt, it will return 2, which is not valid.
*/
public class Solution {
    /**
     * @param nuts: an array of integers
     * @param bolts: an array of integers
     * @param compare: a instance of Comparator
     * @return: nothing
     */
    public void sortNutsAndBolts(String[] nuts, String[] bolts, NBComparator compare) {
        // write your code here
        if(nuts == null || bolts == null || nuts.length == 0 || bolts.length == 0){
            return;
        }
        
        if(nuts.length != bolts.length){
            return;
        }
        
        for(int i = 0; i < nuts.length; i++){
            for(int j = i; j < nuts.length; j++){
                if(compare.cmp(nuts[i], bolts[j]) == 0){
                    swap(bolts, i, j);
                }
            }
        }
    }
    
    public void swap(String[] bolts, int i, int j){
        String tmp = bolts[i];
        bolts[i] = bolts[j];
        bolts[j] = tmp;
    }
};
