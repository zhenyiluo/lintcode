public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
     int m;
     int n;
     boolean[][] visited;
     HashSet<String> ret = new HashSet<>();
     char[][] board;
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        // write your code here
        
        if(board == null || board.length == 0 || board[0].length == 0){
            return new ArrayList<>(ret);
        }
        
        if(words == null || words.size() == 0){
            return new ArrayList<>(ret);
        }
        
        this.board = board;
        Trie trie = new Trie();
        for(String word : words){
            trie.insert(word);
        }
        m = board.length;
        n = board[0].length;
        visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0;j < n; j++){
                dfs(i, j, "", trie);
            }
        }
        
        return new ArrayList<>(ret);
    }
    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};
    private void dfs(int x, int y, String str, Trie trie){
        str = str + board[x][y];
        if(!trie.startsWith(str)){
            return;
        }
        
        if(trie.hasWord(str)){
            ret.add(str);
        }
        
        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]){
                dfs(nx, ny, str, trie);
            }
        }
        visited[x][y] = false;
    }
}

class TrieNode{
    boolean isEnd;
    TrieNode[] children;
    public TrieNode(){
        children = new TrieNode[26];
    }
}
class Trie{
    TrieNode root;
    public Trie(){
        root = new TrieNode();
    }
    
    public void insert(String word){
        if(word == null || word.length() == 0){
            return;
        }
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(cur.children[index] == null){
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }
    
    public boolean startsWith(String word){
        if(word == null || word.length() == 0){
            return false;
        }
        
        TrieNode node = getTrieNode(word);
        return node != null;
    }
    
    public boolean hasWord(String word){
        if(word == null || word.length() == 0){
            return false;
        }
        TrieNode node = getTrieNode(word);
        return node != null && node.isEnd;
    }
    
    private TrieNode getTrieNode(String word){
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(cur.children[index] == null){
                return null;
            }
            cur = cur.children[index];
        }
        return cur;
    }
}
