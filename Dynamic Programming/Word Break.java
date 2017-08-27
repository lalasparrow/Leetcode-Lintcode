/*如果每次都是算整个长度，会超时，所以预处理dict里面最长的String的长度，
就能避免超时*/

public class Solution {
    /*
     * @param s: A string
     * @param dict: A dictionary of words dict
     * @return: A boolean
     */
    public boolean wordBreak(String s, Set<String> dict) {
        // write your code here
        if(s == null || s.length() == 0){
            return true;
        }
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        int maxLen = Integer.MIN_VALUE;
        for(String str : dict){
            maxLen = Math.max(str.length(), maxLen);
        }
        
        
        for(int i=1; i <= len; i++){
            for(int j=1; j<=maxLen&&j<=i; j++){
                // String left = s.substring(0, j);
                String right = s.substring(i-j, i);
                if(dp[i-j] && dict.contains(right)){
                    dp[i] = true;
                    break;
                }
                
                
            }
        }
        
        return dp[len];
    }
}