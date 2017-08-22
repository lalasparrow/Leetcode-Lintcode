/**
注意before = nums[i]的位置应该在swap之前。
其实还有更简单的记before的方法，before就是nums[left]
**/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null || nums.length <= 1){
            return nums.length;
        }
        int left = 1;
        int before = nums[0];
        for(int i=1;i<nums.length;i++){
            if(nums[i] != before){
                before = nums[i];
                swap(nums, left, i);
                left++;
            }
        }
        return left;
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}