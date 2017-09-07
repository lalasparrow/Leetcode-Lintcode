/*
如果A%k = B，并且(A+C)%k = B。那么说明A%k + C%k = B。
两个式子相减，就能得到C%k = 0。
就是这个O(N)的hashmap做法的原理，每次存sum%k的余数 - 当前数字的index。
注意：
1. 需要最开始的时候存(0, -1)这一对。这样能保证答案可以包含从index 0 开始到当前index的值。
2. 还需要保证index的差值大于1，因为题目要求at least 长度2
3. map.put(sum, i)要在else里面，因为如果重复的数字，再次push进map里面的话，可能会因为长度没有被满足而输出false

**/


class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for(int i=0; i < nums.length; i++){
            sum += nums[i];
            if(k != 0){
                sum = sum%k;
            }            
            if(map.containsKey(sum)){
                if(i - map.get(sum) > 1){
                    return true;
                }
            }else{
                map.put(sum, i);
            }
            
        }
        return false;
    }
}
/*
O(N^2)解法，利用sum
*/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = new int[nums.length + 1];
        for(int i = 1; i <= nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                int summ = sum[i] - sum[j] + nums[i];
                if((summ == k) || (k != 0 && summ%k == 0)){
                    return true;
                }
            }
        }
        
        return false;
    }
}

