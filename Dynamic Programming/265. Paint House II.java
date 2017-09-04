/*
如果使用二维数组遍历，时间复杂度O(N*k*k)，但是如果只记录三个变量，
时间复杂度可以达到O(N*K)

需要记录之前最小的值和他涂上的颜色，还有第二小的值，因为如果之前最小的值正好是当前需要涂的颜色，那么就是使用第二小的值。
注意：
1. 如果当前值比原来的第一小的要小，要更换三个temporary变量
2. 如果当前值比第二小的要小，要更新第二小的值
**/

class Solution {
    public int minCostII(int[][] costs) {
        if(costs == null || costs.length == 0 || costs[0].length == 0){
            return 0;
        }
        int n = costs.length;
        int k = costs[0].length;
        
        int preMin = 0;
        int preMinPtr = -1;
        int preSecMin = 0;
        
        for(int i=0;i<n;i++){
            int curMin = Integer.MAX_VALUE;
            int curMinPtr = -1;
            int curSecMin = Integer.MAX_VALUE;
            for(int j=0;j<k;j++){
                int val = j == preMinPtr ? (preSecMin + costs[i][j]) : (preMin + costs[i][j]);
                if(val < curMin){
                    curSecMin = curMin;
                    curMin = val;
                    curMinPtr = j;
                }else if(val < curSecMin){
                    curSecMin = val;
                }
                
            }
            preMin = curMin;
            preMinPtr = curMinPtr;
            preSecMin = curSecMin;            
        }
        
        return preMin;
    }
}