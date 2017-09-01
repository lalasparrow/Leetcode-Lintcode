/*
注意：
1. dp是追前面的值，所以不是i+k，而是i-k
2. 像101这种test case，只有10 + 1这一种，如果在if条件里不加上k的值的话，那么就会把"01" -> 1，但实际上是不满足的
*/

class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0){
            return s.length();
        }
        
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        
        for(int i=2; i <= s.length(); i++){
            for(int k=1; k <=2 && i-k >= 0; k++){
                int val = Integer.valueOf(s.substring(i-k, i));
                
                if(k == 2 && val >= 10 && val <=26){
                    dp[i] += dp[i-2];
                }
                if(k == 1 && val>=1 && val <= 9){
                    dp[i] += dp[i-1];
                }
            }            
        }
        return dp[s.length()];
    }
}