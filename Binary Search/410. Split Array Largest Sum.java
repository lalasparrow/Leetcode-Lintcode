/*
1. binary search

注意：
1. valid()里面，count初始化为1
2. valid()是用来判断，用当前的max值，能不能达到m个subarray。如果大于m个subarray，返回false；否则返回true。
如果返回false了，那么说明需要减少subarray的数目，则需要增大mid。

*/

class Solution {
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int min = nums[0];
        int max = 0;
        for(int i=0; i < nums.length; i++){
            min = Math.max(min, nums[i]);
            max += nums[i];
        }
        if(m == 1){
            return max;
        }
        
        int left = min;
        int right = max;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(valid(nums, m, mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean valid(int[] nums, int m, int mid){
        int count = 1;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > mid){
                sum = nums[i];
                count++;
                if(count > m){
                    return false;
                }
            }            
        }
        return true;
    }
    
}