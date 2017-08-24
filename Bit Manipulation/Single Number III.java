/**
Single Number Summery

一共有三题single number
1. 所有的数字都出现2次，除了一个数只出现1次
2. 所有的数字都出现3次，除了一个数只出现1次（可以延伸到所有的数字都出现了n次）
3. 所有的数字都出现了2次，除了两个数字，每个出现一次


1.比较简单，直接用^（xor），因为xor可以抵消掉相同的数字，因此最后剩下的那个就是这个数字

2.的话拓展到n次。可以这样来做，对于int的32位来说，看看每位出现的次数，如果出现的次数不是三次的话，那么这一位就是这个single number的这一位。技巧是利用%（取余）

3.的话，因为要求两个数字，所以用xor来找这两个数字不同的那一位，用Integer.highestOneBit(i)来取得这一个不相同的位。然后将整个数组分成两个部分，一个部分是这一位为1的，一个部分是这一位为0的。最后获得的两个数字就是这两个数字。

**/



public class Solution {
    /*
     * @param A: An integer array
     * @return: An integer array
     */
    public List<Integer> singleNumberIII(int[] A) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if(A == null || A.length == 0){
            return list;
        }
        int diff = 0;
        for(int i=0;i<A.length;i++){
            diff ^= A[i];
        }
        diff = Integer.highestOneBit(diff);
        int[] res = new int[2];
        for(int i=0;i<A.length;i++){
            if((diff & A[i]) == 0){
                res[0]^=A[i];
            }else{
                res[1]^=A[i];
            }
        }
        
        list.add(res[0]);
        list.add(res[1]);
        return list;
    }
}