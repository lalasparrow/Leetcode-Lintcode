public class Solution {
    /*
     * @param obstacleGrid: A list of lists of integers
     * @return: An integer
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // write your code here
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 0;
        }
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        
        int[][] dp = new int[row][col];
        dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        
        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    if(i-1>=0 && j-1>=0){
                        dp[i][j] += dp[i-1][j] + dp[i][j-1];
                    }else if(i-1>=0&&j<1){
                        dp[i][j] += dp[i-1][j];
                    }else if(i<1&&j-1>=0){
                        dp[i][j] += dp[i][j-1];
                    }
                    
                    
                }
            }
        }
        return dp[row-1][col-1];
    }
}