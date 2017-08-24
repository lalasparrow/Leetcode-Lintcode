/*不要题目是jump game，思路就跟着jump了，还是要O(n)遍历
**/

public class Solution {
    /*
     * @param A: A list of integers
     * @return: A boolean
     */
    public boolean canJump(int[] A) {
        // write your code here
        int fastest = A[0];
        for(int i=1;i<A.length;i++){
            if(fastest >= i && fastest < A[i] + i){
               fastest = A[i] + i; 
            }
        }
        return fastest >= A.length-1 ? true: false;
    }
}