/*
二分搜索看left = mid + 1还是left = mid或者判断right的值的时候，
重要是看mid这个值需要不需要，如果需要的话，就不能+1或者-1
**/

class Solution {
    /**
     * @param A: An integers array.
     * @return: return any of peek positions.
     */
    public int findPeak(int[] A) {
        // write your code here
        if(A == null || A.length <= 2){
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(A[mid] > A[mid - 1] && A[mid] > A[mid + 1]){
                return mid;
            }
            else if(A[mid]>A[mid-1]){
                left = mid;
            }else{
                right = mid;
            }
        }
        return left;
    }
}
