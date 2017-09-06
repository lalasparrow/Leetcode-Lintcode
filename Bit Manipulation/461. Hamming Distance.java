/*
利用异或来把不同的bit变成1，然后计算1的个数
**/
class Solution {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x^y);
    }
}