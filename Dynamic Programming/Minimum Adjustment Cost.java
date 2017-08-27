/*
dp[i][j]表示将第i个元素变成j之后的总花费，
遍历A中的每一个元素i，
每一个元素在0到100之间，
对于第一个元素，即i == 0的情况，初始化dp[i][j]为Math.abs(j - A.get(i))，
对于后面的元素，
使k从0到100进行遍历，i - 1处的位置为这个k的范围，
当满足条件Math.abs(j - k) > target，两者差距足够大的时候，
获取dif的值，并且dp[i][j]和dif进行比较，取得最小值，
最后需要遍历0到100，确定最后一个值，返回最小值
*/

public class Solution {
    /*
     * @param A: An integer array
     * @param target: An integer
     * @return: An integer
     */
    public int MinAdjustmentCost(List<Integer> A, int target) {
        // write your code here
        int len = A.size();
        int[][] dp = new int[len][101];
        int min = Integer.MAX_VALUE;
        
        for(int i=0;i<len;i++){
            for(int j=0;j<101;j++){
                dp[i][j] = Integer.MAX_VALUE;
                if(i==0){
                    dp[i][j] = Math.abs(A.get(i) - j);
                }else{
                    for(int k=0; k < 101; k++){
                        if(Math.abs(k - j) > target){
                            continue;
                        }
                        
                        dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + Math.abs(A.get(i) - j));
                    }
                }
            }
        }
        for(int i=0; i<101; i++){
            min = Math.min(min, dp[len-1][i]);
        }
        
        
        return min;
    }
}