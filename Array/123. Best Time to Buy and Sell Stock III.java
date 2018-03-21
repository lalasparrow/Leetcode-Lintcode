class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2) return 0;
        
        int n = prices.length;
        
        int[] leftMax = new int[n];
        leftMax[0] = 0;
        int localMin = prices[0];
        for(int i = 1; i < prices.length; i ++) {
            localMin = Math.min(localMin, prices[i]);
            leftMax[i] = Math.max(leftMax[i - 1], prices[i] - localMin);
        }
        
        int[] rightMax = new int[n];
        rightMax[n - 1] = 0;
        int localMax = prices[n - 1];
        for(int i = n - 2; i >= 0; i --) {
            localMax = Math.max(localMax, prices[i]);
            rightMax[i] = Math.max(rightMax[i + 1], localMax - prices[i]);
        }
        
        int res = 0;
        for(int i = 0; i < n - 1; i ++) {
            int sum = leftMax[i] + rightMax[i + 1];
            res = Math.max(res, sum);
        }
        
        res = Math.max(res, leftMax[n - 1]);
        return res;
    }
}