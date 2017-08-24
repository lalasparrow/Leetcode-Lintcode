/**
1. ~是补码的意思，~0是32位1。计算方法为取反，+1
2. (1 << (j+1)) - 1 用来获取j个1

把n对应的位置都替换成0，然后用m移位过来，替换成m。
*/
class Solution {
    /**
     *@param n, m: Two integer
     *@param i, j: Two bit positions
     *return: An integer
     */
    public int updateBits(int n, int m, int i, int j) {
        // write your code here
        int max = ~0;
        
        if(j == 31){
            j = max;
        }else{
            j = (1<<(j+1)) - 1;
        }
        int left = max - j;
        int right = ((1<<i) - 1);
        int mask = left | right;
        return (n&mask)|(m<<i);
        
    }
}
