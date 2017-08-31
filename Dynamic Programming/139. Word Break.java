class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }
        
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;
        for(int i=1; i <= len; i++){
            if(wordDict.contains(s.substring(0, i))){
                dp[i] = true;
            }            
        }
        for(int i=1; i <= len; i++){
            for(int j = 0; j < i; j++){
                if(wordDict.contains(s.substring(j, i)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
        
    }
}