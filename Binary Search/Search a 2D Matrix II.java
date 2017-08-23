/*感觉其实不能算是二分搜索..
**/

public class Solution {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)   return 0;
        
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        int sum = 0;
        while(row < m && col >= 0) {
            int num = matrix[row][col];
            if(num == target) {
                sum ++;
                row ++;
                col --;
            } else if(num > target) {
                col --;
            } else {
                row ++;
            }
        }
        
        return sum;
    }
}
