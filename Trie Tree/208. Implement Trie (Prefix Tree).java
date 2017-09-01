class Trie {
    class TrieNode{
        int val;
        TrieNode[] children;
        boolean isWord;
        public TrieNode(int val){
            this.val = val;
            children = new TrieNode[256];
            isWord = false;
        }
    }
    
    TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode(-1);
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i=0; i < word.length(); i++){
            if(cur.children[word.charAt(i)] == null){
                TrieNode node = new TrieNode(word.charAt(i));
                cur.children[word.charAt(i)] = node;
            }
            
            cur = cur.children[word.charAt(i)];
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0; i < word.length(); i++){
            if(cur.children[word.charAt(i)] == null){
                return false;
            }
            cur = cur.children[word.charAt(i)];
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0; i<prefix.length(); i++){
            if(cur.children[prefix.charAt(i)] == null){
                return false;
            }
            cur = cur.children[prefix.charAt(i)];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */