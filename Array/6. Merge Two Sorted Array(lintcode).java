/**
和lintcode 64很像，方法也一样
**/

public class Solution {
    /*
     * @param A: sorted integer array A
     * @param B: sorted integer array B
     * @return: A new sorted integer array
     */
    public int[] mergeSortedArray(int[] A, int[] B) {
        // write your code here
        if(A == null || A.length == 0){
            return B;
        }
        if(B == null || B.length == 0){
            return A;
        }
        int m = A.length;
        int n = B.length;
        int[] res = new int[m + n];
        int ptr1 = 0, ptr2 = 0;
        for(int i=0;i<res.length;i++){
            if(ptr1 < m && ptr2 < n){
                res[i] = A[ptr1] < B[ptr2] ? A[ptr1++] : B[ptr2++];
            }else if(ptr1 < m){
                res[i] = A[ptr1++];
            }else if(ptr2 < n){
                res[i] = B[ptr2++];
            }
        }
        
        return res;
        
    }
}