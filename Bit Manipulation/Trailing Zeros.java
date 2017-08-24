/*
好傻..只要数数看里面有几个5，就能确定有几个零
比如11，里面有1*5，2*5，两个。也就是看最大的五的倍数是几倍
*/

public class Solution {
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        long count = 0;
        while(n != 0){
            count += n/5;
            n /= 5;
        }
        return count;
    }
}