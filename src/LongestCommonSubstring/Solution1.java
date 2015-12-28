public class Solution1 {
    /**
     * @param A, B: Two string.
     * @return: the length of the longest common substring.
     */
    public int longestCommonSubstring(String A, String B) {
        // write your code here
        if(A == null || B == null || A.length() == 0 || B.length() == 0){
            return 0;
        }
        int lenA = A.length();
        int lenB = B.length();
        int ret = 0;
        for(int i = 0; i < lenA; i++){
            for(int j = 0; j < lenB; j++){
                int len = 0;
                int posA = i;
                int posB = j;
                while(posA < lenA && posB < lenB && A.charAt(posA) == B.charAt(posB)){
                    len++;
                    posA ++;
                    posB ++;
                }
                ret = Math.max(ret, len);
            }
        }
        return ret;
    }
}