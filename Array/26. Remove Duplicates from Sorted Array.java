class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length <=1){
            return nums.length;
        }
        
       int res = 0;
        for(int right=0, left = 0; right<nums.length; right++){
            if(nums[right] == nums[left]){
                continue;
            }
            nums[++left] = nums[right];
            res = left;
        }
        return res+1;
    }
    
}