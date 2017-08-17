/*
这题本质上是和valid anagrams(leetcode)/Two Strings Are Anagrams(lintcode)是一样的，做法也相同。
1. sort之后看B有没有走完
时间复杂度：O(NlogN + MlogM)
2. 用count来计数
时间复杂度：O(N + M)
*/

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if(A.length() < B.length()){
            return false;
        }
        char[] cha = A.toCharArray();
        char[] chb = B.toCharArray();
        int ptrA = 0, ptrB = 0;
        Arrays.sort(cha);
        Arrays.sort(chb);
        for(; ptrA < A.length() && ptrB < B.length();){
            if(cha[ptrA] == chb[ptrB]){
                ptrA++;
                ptrB++;
            }else{
                ptrA++;
            }
        }
        
        return ptrB == B.length() ? true : false;
    }
}

public class Solution {
    /**
     * @param A : A string includes Upper Case letters
     * @param B : A string includes Upper Case letter
     * @return :  if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        if(A.length() < B.length()){
            return false;
        }
        int[] count = new int[256];
        for(int i=0;i<A.length();i++){
            count[A.charAt(i)]++;
        }
        for(int i=0;i<B.length();i++){
            count[B.charAt(i)]--;
            if(count[B.charAt(i)] < 0){
                return false;
            }
        }
        return true;
    }
}

