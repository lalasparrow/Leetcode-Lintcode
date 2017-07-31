
/*the maze一共有三题，第一个是找有没有start -> destination的路径，
第二个是找start -> destination最短的路径，第三个是将球滚动的方向变成string输出。
*/

/*490. The Maze -- 找有无路径
dfs没什么好说的，用一个visited数组来标志有没有访问过。
*/

public class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0){
            return true;
        }
        
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start[0], start[1], destination, visited);
        
    }
    
    private boolean dfs(int[][] maze, int x, int y, int[] destination, boolean[][] visited){
        
        if(visited[x][y]){
            return false;
        }
        
        if(x == destination[0] && y == destination[1]){
            return true;
        }
        
        visited[x][y] = true;
        int[] dx = new int[]{-1,1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        
        for(int i = 0; i < 4; i++){
            int xx = x;
            int yy = y;
            while(xx + dx[i] < maze.length && xx + dx[i] >= 0 && yy + dy[i] < maze[0].length && yy + dy[i] >= 0 && maze[xx+dx[i]][yy+dy[i]]!=1){
                xx += dx[i];
                yy += dy[i];
            }
            if(dfs(maze, xx, yy, destination, visited)){
                return true;
            }
            
        }
        
        return false;
        
        
    }
}
/*505. The Maze II
把之前的visited数组改成长度，变成int，然后记录每次的最短距离，如果有更短的就更新，
并且进行下一次dfs。
*/

public class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0){
            return -1;
        }
        int[][] distance = new int[maze.length][maze[0].length];
        for(int[] row: distance){
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;
        
        dfs(maze, start[0], start[1], destination, distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }
    private void dfs(int[][] maze,int x, int y, int[] destination, int[][] distance){
        int[] dx = new int[]{0, 0, -1, 1};
        int[] dy = new int[]{-1, 1, 0, 0};
        for(int i=0;i<4;i++){
            int xx = x;
            int yy = y;
            int count = 0;
            while(xx+dx[i]<maze.length&&xx+dx[i]>=0&&yy+dy[i]<maze[0].length&&yy+dy[i]>=0&&maze[xx+dx[i]][yy+dy[i]]==0){
                xx += dx[i];
                yy += dy[i];
                count++;
            }
            if(distance[x][y] + count < distance[xx][yy]){
                distance[xx][yy] = distance[x][y] + count;
                dfs(maze, xx, yy, destination, distance);
            }            
            
        }
    }    
}

/*499. The Maze III
虽然速度有点慢，只beat了1.25%，但是思路和上面是完全一样的。
因为这次想要记录路径，所以不能光存数字在distance里面了。
因此，新建了一个class，里面装着坐标。坐标里面含有路径，以及路径长度。
同样有一个二维数组，来记录是否visited。但是数组里面装着的是坐标。
因为最后要求输出的string是输出最小的，所以最后当长度一样的时候，
还需再比较一下string的长短，选择更短的，再进行dfs，



*/
public class Solution {
    class Coord{
        int x,y,l;
        String str;
        
        public Coord(int x, int y){
            this.x = x;
            this.y = y;
            this.l = Integer.MAX_VALUE;
            this.str = "";
        }
        public Coord(int x, int y, int l, String str){
            this.x = x;
            this.y = y;
            this.l = l;
            this.str = str;
        }
    }
    
    public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
        Coord[][] distance = new Coord[maze.length][maze[0].length];
        for(int i=0;i<maze.length;i++){
            for(int j=0;j<maze[0].length;j++){
                if(i == ball[0] && j == ball[1]){
                    distance[i][j] = new Coord(i,j,0,"");
                }else{
                    distance[i][j] = new Coord(i,j);
                }
            }
        }
        dfs(maze, ball[0], ball[1], hole, distance);
        return distance[hole[0]][hole[1]].l == Integer.MAX_VALUE?"impossible":distance[hole[0]][hole[1]].str; 
        
    }
    private void dfs(int[][] maze, int x, int y, int[] hole, Coord[][] distance){
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        String[] dir = {"l", "r", "u", "d"};
        for(int i=0;i<4;i++){
            int xx = x;
            int yy = y;
            int count = 0;
            while(xx + dx[i] < maze.length && xx + dx[i] >= 0 && yy + dy[i] < maze[0].length && yy + dy[i] >= 0 && maze[xx+dx[i]][yy+dy[i]]!=1){
                xx += dx[i];
                yy += dy[i];
                count++;
                if(xx == hole[0]&&yy == hole[1]){
                    break;
                }
                
            }
            
            if(distance[x][y].l + count < distance[xx][yy].l){
                distance[xx][yy].l = distance[x][y].l + count;
                String newstr = distance[x][y].str + dir[i];
                distance[xx][yy].str = newstr;
                dfs(maze, xx, yy, hole, distance);
            }else if(distance[x][y].l + count == distance[xx][yy].l){
                if(distance[xx][yy].str.compareTo(distance[x][y].str + dir[i]) > 0){
                    distance[xx][yy].str = distance[x][y].str + dir[i];
                    dfs(maze, xx, yy, hole, distance);
                }
            }
            
            
        }
    }
    
    
}
