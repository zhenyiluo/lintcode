public class Solution {
    /** 
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        if(L == null || L.length == 0 || k <= 0){
            return 0;
        }
        int l = 1;
        int h = 1;
        for(int i = 0 ; i < L.length; i++){
            h = Math.max(h, L[i]);
        }
        while(l <= h){
            int mid = l + ((h-l) >>1);
            if(getNum(mid, L) >= k){
                l = mid+1;
            }else{
                h = mid-1;
            }
        }
        return h;
    }
    
    private int getNum(int num, int[] L){
        int sum = 0;
        for(int n : L){
            sum += n / num;
        }
        
        return sum;
    }
}
