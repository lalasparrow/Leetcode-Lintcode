//1. recursion：需要加上map记忆化搜索，这样不会超时
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    public int combinationSum4(int[] nums, int target) {
        if(target == 0){
            return 1;
        }
        if(target < 0){
            return 0;
        }
        if(map.containsKey(target)){
            return map.get(target);
        }
        
        
        int res = 0;
        for(int i=0; i < nums.length; i++){
            if(target >= nums[i]){
                res += combinationSum4(nums, target - nums[i]);
            }
        }
        
        map.put(target, res);
        return res;
    }
}



//2. dp：记得要在i==nums[j]的时候是+1而不是直接加上之前的值。因为这个数组整个都是0
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        
        for(int i=0; i < dp.length; i++){
            for(int j=0; j < nums.length; j++){
                if(i>nums[j]){
                    dp[i] += dp[i-nums[j]];              
                }else if(i==nums[j]){
                    dp[i] += 1;
                }
            }
        }
        return dp[target];
    }
}


