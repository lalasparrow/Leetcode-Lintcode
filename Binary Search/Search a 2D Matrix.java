/*将2D变成1D*/

public class Solution {
    /*
     * @param matrix: matrix, a list of lists of integers
     * @param target: An integer
     * @return: a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0){
            return false;
        }
        int row = matrix.length, col = matrix[0].length;
        
        int left = 0;
        int right = row*col - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[mid/col][mid%col] == target){
                return true;
            }else if(matrix[mid/col][mid%col] < target){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
            
        }
        return false;
    }
}