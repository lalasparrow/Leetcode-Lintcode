/*还可以用minSum来写，就是利用区间的sum做差的方式
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