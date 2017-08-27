public class Solution {
    /**
     * @param S, T: Two string.
     * @return: Count the number of distinct subsequences
     */
    public int numDistinct(String S, String T) {
        // write your code here
        int m = S.length();
        int n = T.length();
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<=m;i++){
            dp[0][i] = 1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1;j<=m;j++){
                if(T.charAt(i-1) == S.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        
        return dp[n][m];
    }
}