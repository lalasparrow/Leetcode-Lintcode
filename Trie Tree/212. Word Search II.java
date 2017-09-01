/*
注意：
1. 在board[i][j]是children的时候再bfs
2. 在bfs找children的时候，记得圈住board的范围
3. 注意这一句：

        if(root.isWord){
            res.add(root.word);
            root.isWord = false;
        }
要把isWord置为false，否则的话有重复的情况。所以有的答案没有isWord，直接是最后一个放上String，就不用改isWord了

*/

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(words == null || words.length == 0){
            return res;
        }
        Trie trie = new Trie();
        trie.build(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(trie.root.children[board[i][j]] != null){
                    bfs(board, i, j, trie.root.children[board[i][j]], res);
                }
                
            }
        }
        return res;
    }
    private void bfs(char[][] board, int x, int y, TrieNode root, List<String> res){
        
        
        if(root.isWord){
            res.add(root.word);
            root.isWord = false;
        }
        char origin = board[x][y];
        board[x][y] = '#';
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        for(int i=0;i<4;i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(xx<0||xx>=board.length||yy<0||yy>=board[0].length|| board[xx][yy] == '#'){
                continue;
            }
            if(root.children[board[xx][yy]] != null){
                bfs(board, xx, yy, root.children[board[xx][yy]], res);
            }
            
        }
        board[x][y] = origin;
        
    }
    
    class TrieNode{
        int val;
        TrieNode[] children;
        boolean isWord;
        String word;
        public TrieNode(int val){
            this.val = val;
            children = new TrieNode[256];
            isWord = false;
            word = null;
        }
    }
    class Trie{
        TrieNode root;
        public Trie(){
            root = new TrieNode(-1);
        }
        private void build(String[] words){
            for(String word : words){
                TrieNode cur = root;
                for(int i=0;i<word.length();i++){
                    if(cur.children[word.charAt(i)] == null){
                        cur.children[word.charAt(i)] = new TrieNode(word.charAt(i));
                    }
                    
                    cur = cur.children[word.charAt(i)];
                }
                cur.word = word;
                cur.isWord = true;
            }
        }
    }
    
    
    
}