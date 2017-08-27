/*注意dp[0][0]一直等于零。因为s1是0，s2也是0，造成的s3的长度也是0*/
public class Solution {
    /**
     * Determine whether s3 is formed by interleaving of s1 and s2.
     * @param s1, s2, s3: As description.
     * @return: true or false.
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        // write your code here
        int len1 = s1.length();
        int len2 = s2.length();
        int len3 = s3.length();
        if(len1 + len2 != len3){
            return false;
        }
        boolean[][] dp = new boolean[len1+1][len2+1];
        dp[0][0] = true;
        for(int i=1;i<=len2;i++){
            if(s2.charAt(i-1) == s3.charAt(i-1) && dp[0][i-1]){
                dp[0][i] = true;
            }
            
        }
        for(int i=1;i<=len1;i++){
            if(s1.charAt(i-1) == s3.charAt(i-1) && dp[i-1][0]){
                dp[i][0] = true;
            }
            
        }
        for(int i=1; i<=len1; i++){
            for(int j=1; j<=len2; j++){
                if(s1.charAt(i-1) == s3.charAt(i+j-1)&&dp[i-1][j]){
                    dp[i][j] = true;
                }
                if(s2.charAt(j-1) == s3.charAt(i+j-1)&&dp[i][j-1]){
                    dp[i][j] = true;
                }
                
            }
        }
        return dp[len1][len2];
    }
}