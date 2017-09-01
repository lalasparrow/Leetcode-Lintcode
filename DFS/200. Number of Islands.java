class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int res = 0;
        int row = grid.length;
        int col = grid[0].length;
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1'){
                    bfs(grid, i, j, res++);   
                }
                
            }
        }
        return res;
    }
    private void bfs(char[][] grid, int x, int y, int res){
        if(x<0||x>=grid.length||y<0||y>=grid[0].length){
            return;
        }
        if(grid[x][y] == '0'){
            return;
        }
        
        grid[x][y] = '0';
        
        int[] dx = new int[]{0,0,1,-1};
        int[] dy = new int[]{1,-1,0,0};
        for(int i=0; i<4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            bfs(grid, xx, yy, res);
        }
                
    }
}