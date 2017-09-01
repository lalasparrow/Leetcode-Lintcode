class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <= 2){
            return nums.length;
        }
        int i = 0;
        for(int num : nums){
            if(i < 2 || num > nums[i - 2]){
                nums[i++] = num;
            }
        }
        
        return i;
    }
    
    
}