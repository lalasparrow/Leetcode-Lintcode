/*因为只有int，所以情况只要考虑正负就行，反正绝对值是一直往上加的*/


public class Solution {
    /*
     * @param nums: An array of integers
     * @return: An integer
     */
    public int maxProduct(int[] nums) {
        // write your code here
        
        if(nums == null || nums.length == 0){
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        for(int i=1; i < nums.length; i++){
            int tmp = max;
            max = Math.max(Math.max(max*nums[i], min*nums[i]), nums[i]);
            min = Math.min(Math.min(tmp*nums[i], min*nums[i]), nums[i]);
            if(res < max){
                res = max;
            }
        }
       
        return res;
    }
}