/*用三个数组记录当前使用R\G\B中其中一个元素的min cost
*/

class Solution {
    public int minCost(int[][] costs) {
        if(costs.length == 0){
            return 0;
        }
        
        int n = costs.length;
        int[] R = new int[n];
        int[] G = new int[n];
        int[] B = new int[n];
        R[0] = costs[0][0];
        G[0] = costs[0][1];
        B[0] = costs[0][2];
        
        for(int i=1; i < n; i++){
            R[i] = Math.min(G[i-1], B[i-1]) + costs[i][0];
            G[i] = Math.min(R[i-1], B[i-1]) + costs[i][1];
            B[i] = Math.min(R[i-1], G[i-1]) + costs[i][2];
        }
        
        return Math.min(R[n-1], Math.min(G[n-1], B[n-1]));
    }
}