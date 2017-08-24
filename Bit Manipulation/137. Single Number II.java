/*
因为每个都出现三次，只有一个出现一次。那么也就是说，
每个数的某一位的1全部加起来%3应该是0，如果不是0，
那就是那个只出现一次的数字的1。
**/

class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i=0;i<32;i++){
            int sum = 0;
            for(int j=0;j<nums.length;j++){
                if(((nums[j]>>i)&1) == 1){
                    sum++;
                    sum = sum%3;
                }
            }
            if(sum != 0){
                res |= sum<<i;
            }
            
        }
        return res;
    }
}