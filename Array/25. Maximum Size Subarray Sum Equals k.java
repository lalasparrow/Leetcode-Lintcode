/**
看到一个区间的sum的时候，应该想到从0 - present的sum做差可以等到区间的sum的
**/

class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int sum = 0, max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++){
            sum += nums[i];
            if(sum == k){
                max = i + 1;
            }
            else if(map.containsKey(sum - k)){
                max = Math.max(max, i - map.get(sum - k));
            }
            if(!map.containsKey(sum)){
                map.put(sum, i);
            }            
        }
        return max;
    }
}