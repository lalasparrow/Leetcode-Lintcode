/*
注意：
1. 返回的是面积，所以需要res*res
2. matrix是一个char数组，所以不能是==1，应该是=='1'
3. dp[i][0], dp[0][i]表示的是列的个数是0，行的个数是0的情况，所以说都是0。
*/

class Solution {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int res = 0;
        int[][] dp = new int[row+1][col+1];
        dp[0][0] = 0;
     
        for(int i=1; i <= row; i++){
            for(int j=1; j <= col; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                }else{
                    dp[i][j] = 0;
                }
                res = Math.max(res, dp[i][j]);
            }
        }
        return res*res;
        
        
    }
}