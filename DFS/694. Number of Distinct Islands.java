class Solution {
    Set<String> set = new HashSet<>();
    public int numDistinctIslands(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        for(int i=0; i < grid.length; i++){
            for(int j=0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb);
                    set.add(sb.toString());
                }
            }
        }
        for(String str : set){
            System.out.println(str);
        }
        
        return set.size();
    }
    private void dfs(int[][] grid, int x, int y, StringBuilder sb){
        grid[x][y] = 0;
        sb.append("K");
        int[] dx = new int[]{0,0,-1,1};
        int[] dy = new int[]{-1,1,0,0};
        String[] dir = new String[]{"L", "R", "U", "D"};
        for(int i=0; i < 4; i++){
            int xx = x + dx[i];
            int yy = y + dy[i];
            if(xx>=grid.length||yy>=grid[0].length||xx<0||yy<0||grid[xx][yy] == 0){
                continue;
            }
            else{
                dfs(grid, xx, yy, sb);
                sb.append(dir[i]);                
            }  
        }
    }
}
