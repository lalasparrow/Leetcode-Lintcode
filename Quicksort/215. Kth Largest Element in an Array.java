/*
三种解决方法：时间复杂度由低到高
1. sort: O(NlogN)
2. pq: O(Nlogk)
3. quicksort: O(N)
注意：
1. 是第k大，还是第k小

*/


class Solution {
    public int findKthLargest(int[] nums, int k) {
        return helper(nums, k, 0, nums.length - 1);
    }
    private int helper(int[] nums, int k, int start, int end){
        int left = start;
        int right = end;
        int pivot = nums[start];
        while(left<=right){
            while(left<=right && nums[left]>=pivot){
                left++;
            }
            while(left<=right && nums[right]<=pivot){
                right--;
            }
            if(left < right){
                swap(nums, left, right);
            }
        }
        swap(nums, start, right);
        if(right + 1 == k){
            return nums[right];
        }else if(right + 1 < k){
            return helper(nums, k, right+1, end);
        }else {
            return helper(nums, k, start, right-1);
        }
        
        
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}