题目：计算有没有使用加或者减的方法得到S
问：整个数组的sum有大小的限制吗
如果没有，用dp的话，需要用sum(以下的计算方法)来算整个dp数组的大小
int sum = 0;
for(int i=0; i < nums.length; i++){
    sum += nums[i];
}
sum = 2*sum;

The sum of elements in the given array will not exceed 1000.
/*
这题有官方答案：
https://leetcode.com/problems/target-sum/solution/#solution
*/

/*1. 用递归，相当于每个都算一遍这么做，时间复杂度：O(2^N)*/

class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        calculate(nums, 0, 0 , S);
        return count;
    }
    private void calculate(int[] nums, int sum, int i, int target){
        if(i == nums.length){
            if(target == sum){
                count++;
            }
            return;
        }
        calculate(nums, sum + nums[i], i + 1, target);
        calculate(nums, sum - nums[i], i + 1, target);
    }
    
}
/*2. 一维 DP 时间复杂度：O(sum*n)。dp存的是得到当前结果的方法个数
注意：
因为每次都要在上一次nums[i-1]得到的dp结果上面做加减，所以如果直接使用dp数组可能会毁了之前的结果，得到的结果是这次和上次的叠加。
*/

class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[] dp = new int[2001];
        dp[nums[0] + 1000] = 1;
        dp[-nums[0] + 1000] += 1;
        for(int i = 1; i < nums.length; i++){
            int[] next = new int[2001];
            for(int j=-1000; j <= 1000; j++){
                if(dp[j + 1000] > 0){
                    next[j + nums[i] + 1000] += dp[j + 1000];
                    next[j - nums[i] + 1000] += dp[j + 1000];
                }
            }
            dp = next;
        }
        
        
        return S > 1000 ? 0 : dp[S + 1000];
    }
}



/*3. 二维 DP 时间复杂度：O(sum*n)
注意：
1. 最后要判断一下S的大小
2. 只有当dp[i-1][j+1000] > 0的时候，才进行dp的变换，因为0以及0以下都没有必要了。

*/
class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] dp = new int[nums.length][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        
        for(int i=1; i < nums.length; i++){
            for(int j=-1000; j <= 1000; j++){
                if(dp[i-1][j+1000] > 0){
                    dp[i][j + nums[i] + 1000] += dp[i-1][j+1000];
                    dp[i][j - nums[i] + 1000] += dp[i-1][j+1000];
                }
            }
            
        }
        return S > 1000 ? 0 : dp[nums.length - 1][S + 1000];
    }
}


/*4. Recursion with memoization，时间复杂度：O(sum*n)*/

class Solution {
    int count = 0;
    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for(int[] row : memo){
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        
        
        return calculate(nums, 0, S, memo, 0);
    }
    
    private int calculate(int[] nums, int i, int target, int[][] memo, int sum){
        if(i == nums.length){
            if(sum == target){
                return 1;
            }else{
                return 0;
            }
        }
        if(memo[i][sum+1000] != Integer.MIN_VALUE){
            return memo[i][sum+1000];
        }else{
            int add = calculate(nums, i+1, target, memo, sum + nums[i]);
            int subtract = calculate(nums, i+1, target, memo, sum - nums[i]);
            memo[i][sum+1000] = add+subtract;
            return memo[i][sum+1000];
        }
    }
}


