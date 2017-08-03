/*此题需要反方向dp，从p向k走。
注意：
1. 某点的dp肯定是来源于他的下方和和右方。因此要注意行和列在边上的情况
2. 要保证走上来的时候值是>=1的，等于0就直接死了
3. dp[i][j] = Math.max(1, Math.max(dp[i+1][j], dp[i][j+1]) - dungeon[i][j])
如果当前的dungeon[i][j] < 0 的话，那么就需要将这个dungeon的绝对值加上，也就是减去该dungeon；
如果当前的dungeon[i][j] > 0 的话，那么需要和1比较，因为是正的，所以只要让走到dungeon[i][j]是活着的就行了，
因此是和1比较。
*/
public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0){
            return 0;
        }
        int row = dungeon.length;
        int col = dungeon[0].length;
        int[][] dp = new int[row][col];
        for(int i=row-1;i>=0;i--){
            for(int j=col-1;j>=0;j--){
                if(i==row-1&&j==col-1){
                    dp[i][j] = dungeon[i][j] > 0 ? 1 : 1 - dungeon[i][j];
                }else{
                    if(i==dungeon.length - 1){
                        dp[i][j] = Math.max(1, dp[i][j+1] - dungeon[i][j]);
                    }
                    if(j==dungeon[0].length - 1){
                        dp[i][j] = Math.max(1, dp[i+1][j] - dungeon[i][j]);
                    }
                    if(i!= dungeon.length - 1 && j != dungeon[0].length - 1){
                        dp[i][j] = Math.max(1, Math.min(dp[i][j+1], dp[i+1][j]) - dungeon[i][j]);
                    }                    
                }
            }
        }
        
        return dp[0][0];
        
    }
}