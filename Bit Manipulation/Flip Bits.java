/*bit manipulation有点无能为力...
 */

class Solution {
    /**
     *@param a, b: Two integer
     *return: An integer
     */
    public static int bitSwapRequired(int a, int b) {
        // write your code here
        int count = 0;
        for(int i=0;i<32;i++){
            int m = (a>>i) & 1;
            int n = (b>>i) & 1;
            if(m != n){
                count++;
            }
            
        }
        return count;
    }
};
