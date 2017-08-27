/*利用backtracking把每种可能都列举一遍。
人家代码写的真的是艺术啊..

cols这个arraylist，他的index就是Q的row，值就是col
isValid每次就查这一行是否valid，他里面用了cols的size，也就是当前的row是多少

用row = cols.size()是因为row是新一行的row
利用这两个if，把右斜和左斜的点都给排除了。
if((row + column) == (rowIndex + cols.get(rowIndex))){
    return false;
}
if((row - column) == (rowIndex - cols.get(rowIndex))){
    return false;
}
*/

class Solution {
    /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
        // write your code here
        ArrayList<ArrayList<String>> res = new ArrayList<>();
        if(n <= 0){
            return res;
        }
        search(res, new ArrayList<Integer>(), n);
        return res;
        
    }
    private void search(ArrayList<ArrayList<String>> res, ArrayList<Integer> cols, int n){
        if(cols.size() == n){
            res.add(drawChessboard(cols));
            return;
        }

        for(int i=0;i<n;i++){
            if(!isValid(cols, i)){
                continue;
            }
            cols.add(i);
            search(res, cols, n);
            cols.remove(cols.size() - 1);
        }

    }

    private ArrayList<String> drawChessboard(ArrayList<Integer> cols){
        ArrayList<String> chessboard = new ArrayList<>();
        for(int i=0;i<cols.size();i++){
            String str = "";
            for(int j=0;j<cols.size();j++){
                str += cols.get(j) == i ? "Q" : '.';
            }
            chessboard.add(str);
            
        }
        return chessboard;
    }

    private boolean isValid(ArrayList<Integer> cols, int column){
        int row = cols.size();
        for(int rowIndex=0;rowIndex<cols.size();rowIndex++){
            if(cols.get(rowIndex) == column){
                return false;
            }
            if((row + column) == (rowIndex + cols.get(rowIndex))){
                return false;
            }
            if((row - column) == (rowIndex - cols.get(rowIndex))){
                return false;
            }
        }

        return true;
    }



};