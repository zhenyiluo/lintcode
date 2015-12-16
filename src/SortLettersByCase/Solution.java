public class Solution {
    /** 
     *@param chars: The letter array you should sort by Case
     *@return: void
     */
    public void sortLetters(char[] chars) {
        //write your code here
        if(chars == null || chars.length == 0){
            return;
        }
        
        int start = 0; 
        int end = chars.length - 1;
        while(start < end){
            while(start < end && !isUpperCase(chars[start])){
                start ++;
            }
            
            while(start < end && isUpperCase(chars[end])){
                end --;
            }
            
            swap(chars, start, end);
        }
    }
    
    private boolean isUpperCase(char c){
        return c >= 'A' && c <= 'Z';
    }
    
    private void swap(char[] chars, int i, int j){
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }
}
