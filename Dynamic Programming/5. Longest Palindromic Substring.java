class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String res = "";
        
        for(int i=n-1; i >= 0; i--){
            for(int j=i; j < n; j++){
                dp[i][j] = (j-i<3||dp[i+1][j-1]) && s.charAt(i) == s.charAt(j);
                if(dp[i][j] && res.length() < j - i + 1){
                    res = s.substring(i, j+1);
                }
            }
        }        
        return res;
    }
}