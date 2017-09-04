class WordDictionary {
    class TrieNode{
        Character val;
        boolean isWord;
        TrieNode[] children;
        public TrieNode(Character val){
            this.val = val;
            isWord = false;
            children = new TrieNode[26];
        }
    }
    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode(null);
        }
        private void add(String word){
            TrieNode cur = root;
            for(int i=0;i<word.length();i++){
                if(cur.children[word.charAt(i) - 'a'] == null){
                    cur.children[word.charAt(i) - 'a'] = new TrieNode(word.charAt(i));
                }
                cur = cur.children[word.charAt(i) - 'a'];
            }
            cur.isWord = true;
        }
        private boolean search(String word, TrieNode node){
            TrieNode cur = node;
            for(int i=0;i<word.length();i++){
                
                if(word.charAt(i) == '.'){
                    for(int j=0;j<26;j++){
                        if(cur.children[j] != null && search(word.substring(i+1), cur.children[j])){
                            return true;
                        }                        
                    }
                    return false;
                }else{
                    if(cur.children[word.charAt(i) - 'a'] == null){
                        return false;
                    }
                    cur = cur.children[word.charAt(i) - 'a'];
                }
            }
            return cur.isWord ? true : false;
        }
        
    }
    Trie trie;

    /** Initialize your data structure here. */
    public WordDictionary() {
        trie = new Trie();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        trie.add(word);
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return trie.search(word, trie.root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */