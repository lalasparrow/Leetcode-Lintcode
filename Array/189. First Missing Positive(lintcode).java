/**
其实觉得test case挺奇怪的，[1]输出的是2。也就是说，如果整个array正好啥都不差，
那么就输出他的length+1。

另外要注意，如果[1,1]这种情况的时候，到第二个1的时候，
如果不把两个数相同的情况刨除，那么就会一直swap，会超时。
**/


public class Solution {
    /*
     * @param A: An array of integers
     * @return: An integer
     */
    public int firstMissingPositive(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return 1;
        }
        for(int i=0;i<A.length; i++){
            while(A[i] > 0 && A[i] <= A.length && A[i] != i + 1 && A[i] != A[A[i] - 1]){
                swap(A, i, A[i] - 1);
            }
        }
        for(int i=0; i<A.length; i++){
            if(i+1 != A[i]){
                return i+1;
            }
        }
        return A.length + 1;
    }
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}