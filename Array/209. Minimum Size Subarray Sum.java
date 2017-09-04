class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int right = 0; right < nums.length; right++){
            sum += nums[right];
            while(left <= right && sum >= s){
                min = Math.min(min, right - left + 1);
                sum -= nums[left++];
            }
            
        }
        
        return min != Integer.MAX_VALUE ? min : 0;
    }
}