/**
因为说A的长度已经是两个数组数字总数，那么从后往前放数字，可以避免丢数字的情况。
同时要注意三个pointers的范围，都不要越界
**/

class Solution {
    /**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int ptr1 = m - 1;
        int ptr2 = n - 1;
        for(int i = m + n - 1; i >= 0; i--){
            if(ptr1 >= 0 && ptr2 >= 0){
                if(A[ptr1] > B[ptr2]){
                    A[i] = A[ptr1--];
                }else{
                    A[i] = B[ptr2--];
                }
            }else{
                if(ptr1 >= 0){
                    A[i] = A[ptr1--];
                }else{
                    A[i] = B[ptr2--];
                }
            }
            
        }
        
    }
}