class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }   
        int max = 0;
        int tmp = prices[0];
        for(int i=0; i < prices.length; i++){
            if(prices[i] <= tmp){
                tmp = prices[i];
            }else{
                
                max = Math.max(max, prices[i] - tmp);
            }
        }
        return max;
    }
}