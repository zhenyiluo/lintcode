public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        StringBuilder sb = new StringBuilder(A);
        for(int i = 0; i < k; i++){
            boolean flag = false;
            for(int j = 0; j < sb.length()-1; j++){
                if(sb.charAt(j) > sb.charAt(j+1)){
                    flag = true;
                    sb.deleteCharAt(j);
                    break;
                }
            }
            if(!flag){
                sb.deleteCharAt(sb.length() -1);
            }
        }
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
