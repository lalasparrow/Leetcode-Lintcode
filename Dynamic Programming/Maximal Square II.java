public class Solution {
    /**
     * @param matrix a matrix of 0 and 1
     * @return an integer
     */
    public int maxSquare2(int[][] matrix) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int max = 0;
        int[][] dp = new int[r+1][c+1];
        int[][] row = new int[r+1][c+1];
        int[][] col = new int[r+1][c+1];
        
        for(int i=1; i<=r; i++){
            for(int j=1; j<=c; j++){
                if(matrix[i-1][j-1] == 0){
                    dp[i][j] = 0;
                    // row[i][j] = 1;
                    // col[i][j] = 1;
                    // if(i<r){
                    //     col[i][j] = col[i][j-1] + 1;
                    // }
                    // if(j<c){
                    //     row[i][j] = row[i-1][j] + 1;
                    // }
                    col[i][j] = col[i][j-1] + 1;
                    row[i][j] = row[i-1][j] + 1;
                }
                else{
                    row[i][j] = 0;
                    col[i][j] = 0;
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(row[i-1][j], col[i][j-1])) + 1;
                    
                }
                
                max = Math.max(max, dp[i][j]);
            }
        }
        return max*max;
        
    }
}