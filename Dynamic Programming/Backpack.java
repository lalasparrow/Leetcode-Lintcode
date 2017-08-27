/*
注意：
1. 在走dp的时候，不要提前break
2. 还有dp[i][j-1]已经是true了，就可以将dp[i][j]赋值为true了
*/
public class Solution {
    /**
     * @param m: An integer m denotes the size of a backpack
     * @param A: Given n items with size A[i]
     * @return: The maximum size
     */
    public int backPack(int m, int[] A) {
        // write your code here
        int len = A.length;
        boolean[][] dp = new boolean[m+1][len+1];
        for(int i=0;i<=len;i++){
            dp[0][i] = true;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=len;j++){
                if(i-A[j-1]>=0&&dp[i-A[j-1]][j-1]||dp[i][j-1]){
                    dp[i][j] = true;
                }
            }
        }
        int max = 0;
        for(int i=0;i<=m;i++){
            for(int j=0;j<=len;j++){
                if(dp[i][j]){
                    max = Math.max(max, i);
                }     
            }
           
        }
        
        return max;
    }
}