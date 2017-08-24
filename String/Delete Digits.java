/*思路就是如果左边的数字比现在的数字要大的话，就删掉他
一共删除k次。
但是如果要是递增的序列，就不能保证留下的长度是规定的长度，
所以就留下规定的长度就行。
*/
public class Solution {
    /**
     *@param A: A positive integer which has N digits, A is a string.
     *@param k: Remove k digits.
     *@return: A string
     */
    public String DeleteDigits(String A, int k) {
        // write your code here
        if(A == null || A.length() == 0 || k >= A.length()){
            return "";
        }
        int len = A.length();
        String res = A;
        for(int j = 0;j<k;j++){
           for(int i=0;i<A.length()-1;i++){
                if(A.charAt(i)>A.charAt(i+1)){
                    A = A.substring(0, i) + A.substring(i+1);
                    break;
                }
            } 
        }
        if(A.length() > len - k){
            A = A.substring(0, len - k);
        }
        
        while(A.length()>1&&A.charAt(0) == '0'){
            A = A.substring(1);
        }
        return A;
    }
}