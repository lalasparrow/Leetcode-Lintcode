/*
其实思路就是将每一位上面的0和1的个数数出来，然后乘起来，加和
*/

class Solution {
    public int totalHammingDistance(int[] nums) {
        int n = nums.length;
        int total = 0;
        for(int j=0; j < 32; j++){
            int bitCount = 0;
            for(int i=0; i < n; i++){
                bitCount += (nums[i] >> j) & 1;
            }
            total += bitCount*(n-bitCount);
        }
        return total;
    }
}