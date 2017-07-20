/*https://discuss.leetcode.com/topic/30421/share-my-thinking-process?page=1
*/
public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int n = prices.length;
        int[] buy = new int[n];
        int[] sell = new int[n];
        
        buy[0] = -prices[0];
        sell[0] = 0;
        
        for(int i=1;i<n;i++){
            if(i >= 2){
                buy[i] = Math.max(buy[i-1], sell[i-2] - prices[i]);
            }else{
                buy[i] = Math.max(buy[i-1], -prices[i]);
            }
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);     
        }
        
        return sell[n-1];
    }
}


public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length < 2){
            return 0;
        }
        int n = prices.length;
        int pre_buy = Integer.MIN_VALUE, buy = Integer.MIN_VALUE;
        int pre_sell = 0, sell = 0;
        for(int i=0;i<n;i++){
            pre_buy = buy;
            buy = Math.max(pre_sell - prices[i], pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_sell, pre_buy + prices[i]);
        }
        return sell;
        
    }
}