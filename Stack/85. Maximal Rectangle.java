/*多行的histogram
*/

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int maxArea = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] count = new int[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(matrix[i][j] == '1'){
                    count[i][j] = i == 0 ? 1 : count[i-1][j] + 1;
                }
            }
        }
       
        for(int i=0; i < row; i++){
            maxArea = Math.max(maxArea, findMaxArea(count[i]));
        }
        return maxArea;
    }
    private int findMaxArea(int[] count){
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        
        for(int i=0; i <= count.length; i++){
            int cur = i == count.length ? -1 : count[i];
            while(!stack.isEmpty() && count[stack.peek()] >= cur){
                int h = count[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h*w);
            }
            stack.push(i);
        }
        
        
        return maxArea;
    }    
    
}