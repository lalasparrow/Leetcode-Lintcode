/**
和quicksort里面交换的地方是一样的
**/

public class Solution {
    /*
     * @param nums: The integer array you should partition
     * @param k: An integer
     * @return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while(left <= right){
            while(left <= right && nums[left] < k){
                left++;
            }
            while(left <= right && nums[right] >= k){
                right--;
            }
            if(left <= right){
                swap(nums, left, right);
                left++;
                right--;
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