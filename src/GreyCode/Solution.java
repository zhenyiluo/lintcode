public class Solution {
    /**
     * @param n a number
     * @return Gray code
     */
    public ArrayList<Integer> grayCode(int n) {
        // Write your code here
        ArrayList<Integer> ret = new ArrayList<Integer>();
        if(n == 0){
            ret.add(0);
            return ret;
        }
        
        ret.add(0);
        ret.add(1);
        for(int i = 1; i < n; i++){
            int val = 1 << i;
            for(int j = ret.size()-1; j >= 0; j--){
                ret.add(ret.get(j) + val);
            }
        }
        return ret;
    }
}
