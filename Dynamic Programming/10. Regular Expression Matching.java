/*
initialization:
如果有*的话，可以消除前面一个char

function:
1. s在i-1，p在j-1的时候相等，或者p是.的话，
    dp[i][j] = dp[i-1][j-1];
2. 如果p在j-1的时候是'*'的话：
分为以下几种情况：
    a."aaaaa"和"a*"，一个*和多个数字匹配
    这种情况把aaaaa变成aaaa，一直缩短aaaaa的长度，因此：
        dp[i][j] = dp[i-1][j]
    条件是：s在i-1时候的char == p在i-2时候的char，或者p在i-2时候的char是'.'
    b."a"和"ab*"，*消除掉前面的一个char
        dp[i][j] = dp[i][j-2]
    条件是：和a.相同
    c."aa"和"a*"，*匹配一个
        dp[i][j] = dp[i][j-1]
    条件是：和a.相同
（上述的条件相同）
还有else，
    dp[i][j] = dp[i][j-2]
*/


class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for(int i=2;i<=n; i++){
            if(p.charAt(i-1) == '*'){
                dp[0][i] = dp[0][i-2];
            }
        }
        for(int i=1; i <= m; i++){
            for(int j=1; j <=n; j++){
                if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '.'){
                    dp[i][j] = dp[i-1][j-1];
                }
                
                if(p.charAt(j-1) == '*'){
                    if(s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.'){
                        dp[i][j] = dp[i][j-2] || dp[i-1][j] || dp[i][j-1];
                    }else{
                        dp[i][j] = dp[i][j-2];
                    }
                }                
            }
        }
        return dp[m][n];
    }
}