/*
里面2的原理是，不管是max还是min的话，两个的起点都是0，对于min来说，最大的就是0；
对于max来说，最小的就是0，因此遇到比0还小的还不如不加上，所以就新起一段了。

计算max或者是min的方法都是一样的，
1. dp
2. 利用当前sum值和0的大小来判断是继续加还是新起一段 
计算max-subarray的时候，如果sum < 0之后，要把sum置为0，计算下一段的sum。
方法：
1. dp，在，新起一段，还是从继续接着上面的那一段开始加，里面去最大值
2. sum < 0的时候，新起一段；sum >= 0的时候，继续加。

计算min-subarray的时候，
方法：
1. dp，在，新起一段，还是从继续接着上面的那一段开始加，里面去最小值
2. sum <= 0 的时候，继续加；sum > 0的时候，新起一段。


*/
public class Solution {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        if(nums == null || nums.size() == 0)    return 0;
        
        int[] dp = new int[nums.size()];
        dp[0] = nums.get(0);
        int min = nums.get(0);
        for(int i = 1; i < nums.size(); i ++) {
            dp[i] = Math.min(nums.get(i), dp[i - 1] + nums.get(i));
            min = Math.min(min, dp[i]);
        }
        
        return min;
    }
}

public class Solution {
    /*
     * @param nums: a list of integers
     * @return: A integer indicate the sum of minimum subarray
     */
    public int minSubArray(List<Integer> nums) {
        // write your code here
        if(nums == null || nums.size() == 0){
            return 0;
        }
        int len = nums.size();
         int minSum = nums.get(0);  
        int tempSum=0;  
        for(int j=0; j<len;j++){  
            if(tempSum <= 0)  
                tempSum += nums.get(j);  
            else  
                tempSum = nums.get(j);  
                 
            if(tempSum < minSum)  
                minSum = tempSum;  
        }  
        return minSum;  
    }
}