/*小技巧，在最开始加上一个），不会增加括号对数目，同时能用一个if帮助判断所有情况。
*/

public class Solution {
    public int longestValidParentheses(String s) {
        s = ")" + s;
        int[] dp = new int[s.length() + 1];
        int max = 0;
        for(int i =1;i<s.length();i++){
            if(s.charAt(i) == ')' && s.charAt(i- dp[i-1] - 1) == '('){
                dp[i] = dp[i-1] + dp[i-dp[i-1] - 2] + 2;
                max = Math.max(max, dp[i]);
            }
        }
      return max;
    }
}