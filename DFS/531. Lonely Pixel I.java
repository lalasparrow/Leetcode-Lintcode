/*思路是将每一行每一列的B的个数数出来，在遍历一遍，如果遇到B的话，
并查看该行和该列B的数目。这样需要的时间复杂度是O(M*N)，空间复杂度是O(M+N).

改进1：空间复杂度变成O(M)，只记录行或者列的B的个数，然后在第二次遍历的时候，
每次记录列或者行的B的个数，以及B出现的列或者行，如果遍历完该行之后，
B的数目如果只有一个，并且在那一列也只有一个B，则res++。

改进2：空间复杂度变成O(1)..


*/

public class Solution {
    public int findLonelyPixel(char[][] picture) {
        if(picture == null || picture.length == 0){
            return 0;
        }
        int row = picture.length;
        int col = picture[0].length;
        int[] rowCount = new int[row];
        int[] colCount = new int[col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(picture[i][j] == 'B'){
                    rowCount[i]++;
                    colCount[j]++;
                }
            }
        }
        int res = 0;
        for(int i=0; i<row; i++){
            for(int j=0;j<col;j++){
                if(picture[i][j] == 'B' && rowCount[i] == 1 && colCount[j] == 1){
                    res++;
                }
            }
        }
        
        return res;
       
    }
}