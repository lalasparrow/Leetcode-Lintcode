1. 最长的回文substring

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

2. substring是回文的substring的个数
/*和1一样的dp解*/
class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if(dp[i][j]) ++res;
            }
        }
        return res;
    }
    
}
public int countSubstrings(String s) {
    int res = 0, n = s.length();
    for(int i = 0; i<n ;i++ ){
        //i is the middle index of the substring
        for(int j = 0; i-j >= 0 && i+j < n && s.charAt(i-j) == s.charAt(i+j); j++){
            res++;
        }


        //(i-1, i) is the middle index of the substring
        for(int j = 0; i-1-j >= 0 && i+j < n && s.charAt(i-1-j) == s.charAt(i+j); j++){
            res++;
        }
    }
    return res;
}

