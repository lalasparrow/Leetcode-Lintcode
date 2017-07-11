/*
2D的index转换成1D的index
2D matrix node : matrix[i][j]
->
1D array node : array[i*col + j]

1D的index转换成2D的index
1D array node : array[i]
->
2D matrix node : matrix[i/col][i%col]

之后用binary search就很简单了。
*/

public class Solution {
    private int row;
    private int col;
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        
        row = matrix.length;
        col = matrix[0].length;
        
        int left = 0;
        int right = row*col - 1;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            if(matrix[mid/col][mid%col] == target){
                return true;
            }else if(matrix[mid/col][mid%col] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return false;
    }
}