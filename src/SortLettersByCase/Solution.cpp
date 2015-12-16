class Solution {
public:
    /** 
     * @param chars: The letters array you should sort.
     */
    void sortLetters(string &letters) {
        // write your code here
        if(letters.size() == 0){
            return;
        }
        
        int start = 0;
        int end = letters.size() -1;
        while(start < end){
            while(start < end && !isUpperCase(letters[start])){
                start ++;
            }
            
            while(start < end && isUpperCase(letters[end])){
                end --;
            }
            
            swap(letters, start, end);
        }
    }
    
    void swap(string &letters, int start, int end){
        char tmp = letters[start];
        letters[start] = letters[end];
        letters[end] = tmp;
    }
    
    bool isUpperCase(char c){
        return c >= 'A' && c <= 'Z';
    }
};
