/*用minSum来写，就是利用区间的sum做差的方式
 
 至今为止的max sum - 至今为止的min sum，就是某段区间最大的值
*/

public class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = Integer.MIN_VALUE, min = 0;
        int prefixSum = 0;
        for(int i = 0; i < nums.length; i++){
            prefixSum += nums[i];
            max = Math.max(max, prefixSum - min);
            min = Math.min(min, prefixSum);
        }
        return max;
    }
}
/*
 Kadane's Algorithm
 
 题目默认的是最小的max是0，就是一个空array的情况，这样的话，如果sum<0就直接置为零。
 有负数的array必然不会成为maximum subarray，所以[-1,4,3]这个array必然不是答案，因为会有[4,3]这个arraysum比他大
 
 
 */
public class Solution {
    /*
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code here
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            sum += nums[i];
            max = Math.max(max, sum);
            if(sum < 0){
                sum = 0;
            }
            
        }
        return max;
    }
}
