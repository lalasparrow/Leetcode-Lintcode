/*
找到只有还要reverse。
*/

public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A list of integers
     */
    public int[] nextPermutation(int[] nums) {
        // write your code here
        
        int idx = -1;
        for(int i = nums.length - 2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;
            }
        }
        // System.out.println(idx+" "+nums[idx]);
        
        if(idx != -1){
            int bigger = nums.length - 1;
            while(bigger<nums.length && nums[bigger]<= nums[idx]){
                bigger--;   
            }
            swap(nums, idx, bigger);
            
        }
        reverse(nums, idx+1, nums.length - 1);
        return nums;
    }
    private void reverse(int[] nums, int i, int j){
        while(i < j){
            swap(nums, i, j);
            i++;
            j--;
        }
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}