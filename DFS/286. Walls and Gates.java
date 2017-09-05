/*
最开始在return的if里面加上了dis+1>=room[x][y]，直接把0这种情况给扔了，所以数组不变..

所以最后return的条件应该是dis>room[x][y]
*/
class Solution {
    public void wallsAndGates(int[][] rooms) {
        if(rooms == null || rooms.length == 0 || rooms[0].length == 0){
            return;
        }
        int row = rooms.length;
        int col = rooms[0].length;
        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(rooms[i][j] == 0){
                    dfs(rooms, i, j, 0);
                }
            }
        }
        
    }
    
    private void dfs(int[][] rooms, int x, int y, int dis){
        
        if(x<0||x>=rooms.length||y<0||y>=rooms[0].length||rooms[x][y] == -1||dis>rooms[x][y]){
            return;
        }
        
        rooms[x][y] = dis;        
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};
        
        for(int i=0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            dfs(rooms, xx, yy, dis+1);
        }        
    }
}