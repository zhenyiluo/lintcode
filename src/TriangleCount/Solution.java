public class Solution {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int S[]) {
        // write your code here
        if(S == null || S.length < 3){
            return 0;
        }
        
        Arrays.sort(S);
        int len = S.length;
        int count = 0;
        
        for(int i = 0; i < len -2; i++){
            for(int j = i+1; j < len -1; j++){
                for(int k = len -1; k > j; k--){
                    if(S[i] + S[j] > S[k]){
                        count += k - j;
                        break;
                    }
                }
            }
        }
        
        return count;
    }
}

