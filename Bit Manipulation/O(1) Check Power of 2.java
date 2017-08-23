/*
如果n&(n-1) == 0那么说明是2的几次方。
因为如果是奇数的话，最后一位是1，减去1之后，不会影响其他位，因此n&(n-1)其他位不是零。
如果是偶数的话，最后一位是0，减去1之后，前面的会顺次借位，最后算式结果会为0
*/

class Solution {
    /*
     * @param n: An integer
     * @return: True or false
     */
    public boolean checkPowerOf2(int n) {
        // write your code here
        if(n <= 0){
            return false;
        }
        return (n&(n-1)) == 0 ? true: false;
    }
};