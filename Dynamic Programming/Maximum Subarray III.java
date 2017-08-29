public class Solution {
    /*
     * @param nums: A list of integers
     * @param k: An integer denote to find k non-overlapping subarrays
     * @return: An integer denote the sum of max k non-overlapping subarrays
     */
    public int maxSubArray(int[] nums, int k) {
        // write your code here
        int n = nums.length;
        int[][] localMax = new int[n+1][k+1];
        int[][] globalMax = new int[n+1][k+1];
        
        for(int i=1;i<n+1;i++){
            for(int j=1;j<=i&&j<=k;j++){
                //since localMax[i][j] may equals to localMax[i-1][j], and k cannot larger than j, therefore, set localMax[j-1][j] = Integer.MIN_VALUE;
                localMax[j-1][j] = Integer.MIN_VALUE;
                localMax[i][j] = Math.max(localMax[i-1][j], globalMax[i-1][j-1]) + nums[i-1];
                if(i==j){
                    globalMax[i][j] = localMax[i][j];
                }else{
                    globalMax[i][j] = Math.max(localMax[i][j], globalMax[i-1][j]);
                }
            }
        }
        return globalMax[n][k];
    }
}

/*
localMax[i][j]表示前i个元素，j个subarray，且第i个元素必须取得时候的，最大值，
globalMax[i][j]表示前i个元素，j个subarray，且第i个元素可以取也可以不取的时候的，最大值，
localMax[i][j] = Math.max(localMax[i - 1][j], globalMax[i - 1][j - 1]) + nums[i - 1];
1. 前i-1个元素，且第i-1个必须取，分成j个subarray，再加上的nums[i - 1]为第i个元素，跟第i-1个元素合成，不新增加subarray
2. 前i-1个元素，第i-1个可以取可以不取，分成j-1个subarray，再加上的nums[i - 1]为第i个元素，新增加一个subarray
1和2的max变成localMax[i][j]
globalMax[i][j] = Math.max(globalMax[i - 1][j], localMax[i][j]);
1. 不取第i-1个元素，j个subarray
2. 取第i-1个元素，j个subarray
1和2的max变成globalMax[i][j]；
当i<j时候，无法分，直接令localMax[j - 1][j] = Integer.MIN_VALUE;
而当i==j的时候，直接分，令globalMax[i][j] = localMax[i][j];
*/