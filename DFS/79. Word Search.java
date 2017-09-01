class Solution {
    public boolean exist(char[][] board, String word) {
        if(word == null || word.length() == 0){
            return true;
        }
        
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        int idx = 0;
        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(word.charAt(idx) == board[i][j] && bfs(board, i, j, word, idx, visited)){
                    return true;
                }
                
            }
        }
        return false;
        
        
    }
    
    private boolean bfs(char[][] board, int x, int y, String word, int idx, boolean[][] visited){
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};
        if(idx == word.length()){
            return true;
        }
        
        if(x<0||x>=board.length||y<0||y>=board[0].length||visited[x][y]||board[x][y] != word.charAt(idx)){
            return false;
        }
        visited[x][y] = true;
        if(bfs(board, x, y-1, word, idx+1, visited)||
           bfs(board, x, y+1, word, idx+1, visited)||
           bfs(board, x-1, y, word, idx+1, visited)||
           bfs(board, x+1, y, word, idx+1, visited)
          ){
            return true;
        }
        visited[x][y] = false;
        return false;
    }
}