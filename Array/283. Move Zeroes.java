class Solution {
    public void moveZeroes(int[] nums) {
        for(int left = 0, right = 0;right < nums.length; right++){
            if(nums[right] != 0){
                swap(nums, right, left);
                left++;
            }
        }
    }
    private void swap(int[] nums, int j, int i){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}