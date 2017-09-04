/*和求subarray sum做差相似，这里是求部分的production。
第二次遍历可以用一个int来替代一个数组，节约了空间
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        res[0] = 1;
        for(int i=1; i < nums.length; i++){
            res[i] = res[i-1]*nums[i-1];
        }
        int right = 1;
        for(int i=nums.length - 1; i >= 0; i--){
            res[i] = right*res[i];
            right = right * nums[i];
        }
        
        return res;
    }
}