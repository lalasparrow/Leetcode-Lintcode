/*
题目：把一个array分成m个subarray，问怎么分能让Math.max(每个subarray的自己的sum)最小
 */

/*
1. binary search
时间复杂度：O((N-M)log(N-M))
 假如整个数组的每个元素的最小值是M，整个数组的sum是N
 
空间复杂度：O(1)
 
注意：
1. valid()里面，count初始化为1
2. valid()是用来判断，用当前的max值，能不能达到m个subarray。如果大于m个subarray，返回false；否则返回true。
如果返回false了，那么说明需要减少subarray的数目，则需要增大mid。

*/

class Solution {
    public int splitArray(int[] nums, int m) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int min = nums[0];
        int max = 0;
        for(int i=0; i < nums.length; i++){
            min = Math.max(min, nums[i]);
            max += nums[i];
        }
        if(m == 1){
            return max;
        }
        
        int left = min;
        int right = max;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(valid(nums, m, mid)){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return left;
    }
    private boolean valid(int[] nums, int m, int mid){
        int count = 1;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(sum > mid){
                sum = nums[i];
                count++;
                if(count > m){
                    return false;
                }
            }            
        }
        return true;
    }
    
}

/*dp
 时间复杂度：O()
 
 空间复杂度：O(N)
 */
class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        int[] dp = new int[n+1];
        for (int i = n-1; i >= m-1; --i) {
            dp[i] = dp[i+1] + nums[i];
        }
        //求这m个subarray
        for (int k = 2; k <= m; ++k) {
            for (int i = m-k; i <= n-k; ++i) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = i, sum = 0; j <= n-k; ++j) {
                    sum += nums[j];
                    if (sum >= dp[i]) break;
                    dp[i] = Math.max(sum, dp[j+1]);
                }
                if (k == m) break;
            }
        }
        return dp[0];
    }
}


