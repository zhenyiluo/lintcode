class Solution {
    /**
      * @param board: the board
        @return: wether the Sudoku is valid
      */
    public static final int SIZE = 9;
    public boolean isValidSudoku(char[][] board) {
        // check rows
        HashSet<Character> hs;
        for(int i = 0; i < SIZE; i++){
             hs = new HashSet<Character>();
             for(int j = 0; j < SIZE; j++){
                 char c = board[i][j];
                 if(c == '.'){
                     continue;
                 }
                 if(c < '0' || c > '9' || hs.contains(c)){
                     return false;
                 }else{
                     hs.add(c);
                 }
             }
        }
        
        // check columns
        for(int j = 0; j < SIZE; j++){
             hs = new HashSet<Character>();
             for(int i = 0; i < SIZE; i++){
                 char c = board[i][j];
                 if(c == '.'){
                     continue;
                 }
                 if(c < '0' || c > '9' || hs.contains(c)){
                     return false;
                 }else{
                     hs.add(c);
                 }
             }
        }
        
        // check sub- 3*3 squares
        
        for(int i = 0; i < SIZE/3; i++){
            for(int j = 0; j < SIZE/3; j++){
                hs = new HashSet<Character>();
                for(int k = 0; k < SIZE/3; k++){
                    for(int l = 0; l < SIZE/3; l++){
                        char c = board[i*3 + k][j*3+ l];
                        if(c == '.'){
                            continue;
                        }
                        if(c < '0' || c > '9' || hs.contains(c)){
                            return false;
                        }else{
                            hs.add(c);
                        }
                    }
                }
            }
        }
        
        
        return true;
    }
};
