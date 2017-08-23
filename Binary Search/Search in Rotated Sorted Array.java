/*while的判断条件是left+1<right。因为有可能mid会一直等于left，
一直跳不出来循环的状况
**/

public class Solution {
    /*
     * @param A: an integer rotated sorted array
     * @param target: an integer to be searched
     * @return: an integer
     */
    public int search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int left = 0;
        int right = A.length - 1;
        while(left + 1< right){
            int mid = left + (right - left)/2;

            if(A[mid] == target){
                return mid;
            }else if(A[left] == target){
                return left;
            }else if(A[right] == target){
                return right;
            }
            if(A[mid] >= A[right]){
                if(target <= A[mid] && target >= A[left]){
                    right = mid;
                }else {
                    left = mid;
                }
            }
            else{
                if(target >= A[mid] && target<=A[right]){
                    left = mid;
                }else{
                    right = mid;
                }
            }
        }
        
      
        return A[left] == target ? left : -1;
        
    }
}