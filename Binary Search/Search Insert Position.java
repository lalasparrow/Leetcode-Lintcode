public class Solution {
    /*
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: An integer
     */
    public int searchInsert(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return 0;
        }
        int left = 0;
        int right = A.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(target == A[mid]){
                return mid;
            }else if(A[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }
        
        return left;
    }
}