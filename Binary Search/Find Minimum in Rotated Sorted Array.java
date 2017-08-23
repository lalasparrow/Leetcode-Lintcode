/**
注意这里循环判断条件不能有"="了，因为如果有等号的话，在mid == left == right的时候，
就会一直在循环里，因为不满足所有if的条件，这样mid不会更新，就会超时。

所以判断条件是left < right。
在nums[left] < nums[right]的时候，说明此是序列是递增的，返回left的值
 /  
/  
  /     这是mid > left的情况，这样的话，最小值是在mid之后，所以赋值left = mid + 1


/ 
  /
 /      else，最小值是在mid之前，所以赋值right = mid
最后返回的是nums[right]的值，其实left也是对的，因为这时候left == right

这块这里，

if(nums[mid] < nums[left]){
    right = mid;
}
else{
    left = mid + 1;
}
因为nums[mid] >= nums[left]肯定没有答案，所以mid+1

**/

public class Solution {
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[left] < nums[right]){
                return nums[left];
            }
            
            if(nums[mid] < nums[left]){
                right = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return nums[right];
    }
}