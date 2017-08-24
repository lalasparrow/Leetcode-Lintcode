/*是按照左侧和右侧node的数目来进行dp的
j是左侧，i-j-1是右侧，减一是因为root有一个，所以要减去1
**/

class Solution {
    public int numTrees(int n) {
        int[] count = new int[n+1];
        count[0] = 1;
        count[1] = 1;
        
        for(int i=2; i <= n; i++){
            for(int j=0; j<i; j++){
                count[i] += count[j]*count[i-j-1];
            }
        }
        return count[n];
    }
}