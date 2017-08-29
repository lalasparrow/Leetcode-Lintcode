/*
注意这个单词加入res之后，isWord要变成false。避免重复加入res。
*/

public class Solution {
    /**
     * @param board: A list of lists of character
     * @param words: A list of string
     * @return: A list of string
     */
    class TrieNode{
        Character val;
        boolean isWord;
        TrieNode[] children;
        public TrieNode(){
            val = null;
            isWord = false;
            children = new TrieNode[26];
        }
        
        public TrieNode(char val){
            this.val = val;
            isWord = false;
            children = new TrieNode[26];
        }
        
    }
    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        private void add(String word){
            TrieNode cur = root;
            for(int i=0;i<word.length(); i++){
                char ch = word.charAt(i);
                if(cur.children[ch - 'a'] == null){
                    cur.children[ch - 'a'] = new TrieNode(ch);
                }
                cur = cur.children[ch - 'a'];
            }
            cur.isWord = true;
        }
    }
    private void searchAndAdd(char[][] board, ArrayList<String> words, int x, int y, StringBuilder sb, TrieNode root, ArrayList<String> res){
        if(root.isWord){
            res.add(sb.toString());
            root.isWord = false;
        }

        if(x<0||x>=board.length||y<0||y>=board[0].length||board[x][y]=='#'){
            return;
        }
        char tmp = board[x][y];
        int len = sb.length();
        if(root.children[tmp - 'a'] == null){
            return;
        }
        
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,-1,1};
        
        for(int i=0;i<4;i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            sb.append(board[x][y]);
            board[x][y] = '#';
            searchAndAdd(board, words, xx, yy, sb, root.children[tmp - 'a'], res);
            board[x][y] = tmp;
            sb.setLength(len);
        }
        
    }
    
    public ArrayList<String> wordSearchII(char[][] board, ArrayList<String> words) {
        ArrayList<String> res = new ArrayList<>();
        if(board == null || board.length == 0 || board[0].length == 0){
            return res;
        }
        Trie trie = new Trie();
        int row = board.length;
        int col = board[0].length;
        
        for(String word : words){
            trie.add(word);
        }
        
        for(int i=0;i<row; i++){
            for(int j=0;j<col;j++){
                searchAndAdd(board, words, i, j, new StringBuilder(), trie.root, res);
            }
        }
        return res;
    }
    
}