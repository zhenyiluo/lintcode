/**
 * Your Trie object will be instantiated and called as such:
 * Trie trie = new Trie();
 * trie.insert("lintcode");
 * trie.search("lint"); will return false
 * trie.startsWith("lint"); will return true
 */
class TrieNode {
    // Initialize your data structure here.
    TrieNode[] children;
    boolean isEnd;
    public TrieNode() {
        children = new TrieNode[26];
    }
}

public class Solution {
    private TrieNode root;

    public Solution() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word == null || word.length() == 0){
            return;
        }
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int index = c - 'a';
            if(cur.children[index]==null){
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isEnd = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = getNode(word);
        return cur != null && cur.isEnd;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = getNode(prefix);
        return cur != null;
    }
    
    private TrieNode getNode(String word){
        if(word == null || word.length() == 0){
            return null;
        }
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
