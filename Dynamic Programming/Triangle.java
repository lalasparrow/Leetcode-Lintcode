/*
不要因为是三角形就想歪了，其实就是个正方形
*/

public class Solution {
    /**
     * @param triangle: a list of lists of integers.
     * @return: An integer, minimum path sum.
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here
        if(triangle == null || triangle.length == 0 || triangle[0].length == 0){
            return 0;
        }
        int height = triangle.length;
        int[] dp = new int[height];
        for(int i=0;i<height;i++){
            dp[i] = triangle[height - 1][i];
        }
        for(int i=height-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle[i][j];
            }
        }
        
        return dp[0];
        
    }
}
