public class Solution {
    /*
     * @param A: an integer ratated sorted array and duplicates are allowed
     * @param target: An integer
     * @return: a boolean 
     */
    public boolean search(int[] A, int target) {
        // write your code here
        if(A == null || A.length == 0){
            return false;
        }
        
        int left = 0, right = A.length - 1;
        while(left + 1< right){
            int mid = left + (right - left)/2;

            if(A[mid] == target){
                return true;
            }
            
            if(A[mid] < A[left]){
                if(target>=A[mid]&& target <= A[right]){
                    left = mid;
                }else{
                    right = mid;
                }
            }
            else if(A[mid] > A[left]){
                if(target<=A[mid]&&target>=A[left]){
                    right = mid;
                }else{
                    left = mid;
                }
            }
            else{
                left++;
            }
            
        }
        
        
        return A[left] == target || A[right] == target? true:false;
    }
}