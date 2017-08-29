/*
对于local，global模板应用的综合考察。
一个最大的ABS diff可能由两种情况获得：
1. 左边最大减去右边最小
2. 左边最小减去右边最大

注意：求max的时候，minSum之后在更新，因为minSum = Math.min(minSum, sum);
maxSum = Math.max(maxSum, sum - minSum);
minSum提前更新了的话，sum - minSum就是0了
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two
     *          Subarrays
     */
    public int maxDiffSubArrays(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int n = nums.length;
        int[] left_max = new int[n];
        int[] left_min = new int[n];
        int[] right_max = new int[n];
        int[] right_min = new int[n];
        
        
        int maxSum = Integer.MIN_VALUE;
        int minSum = 0;
        int sum = 0;
        
        //left max
        for(int i=0; i < n; i++){
            sum += nums[i];
            maxSum = Math.max(maxSum, sum - minSum);
            minSum = Math.min(minSum, sum);
            left_max[i] = maxSum;
        }
        
        maxSum = 0;
        minSum = Integer.MAX_VALUE;
        sum = 0;
        
        //left min
        for(int i=0; i < n; i++){
            sum += nums[i];
            minSum = Math.min(minSum, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
            left_min[i] = minSum;
        }
        
        maxSum = Integer.MIN_VALUE;
        minSum = 0;
        sum = 0;
        
        //right max
        for(int i=n-1; i>=0; i--){
            sum += nums[i];
            maxSum = Math.max(maxSum, sum - minSum);
            minSum = Math.min(minSum, sum);
            right_max[i] = maxSum;
        }
        
        maxSum = 0;
        minSum = Integer.MAX_VALUE;
        sum = 0;
        
        //right min
        for(int i=n-1; i>=0; i--){
            sum += nums[i];
            minSum = Math.min(minSum, sum - maxSum);
            maxSum = Math.max(maxSum, sum);
            right_min[i] = minSum;
        }
        
        int res = 0;
        for(int i=0;i<n-1;i++){
            res = Math.max(res, Math.max(Math.abs(left_max[i] - right_min[i+1]), Math.abs(left_min[i]-right_max[i+1])));
        }
        return res;
    }
}

