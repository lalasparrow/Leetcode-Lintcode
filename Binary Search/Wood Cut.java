/*
不知道为什么left初始值不能是0..是0的话有个test case过不了

*/

public class Solution {
    /*
     * @param L: Given n pieces of wood with length L[i]
     * @param k: An integer
     * @return: The maximum length of the small pieces
     */
    public int woodCut(int[] L, int k) {
        // write your code here
        int max = Integer.MIN_VALUE;
        
        for(int i=0;i<L.length;i++){
            max = Math.max(max, L[i]);
        }
        int left = 1, right = max;
        while(left + 1< right){
            int mid = left + (right - left)/2;
            int cut = pieces(L, mid);
            if(cut < k){
                right = mid;
            }
            else{
                left = mid;
            }
        }
        if(pieces(L, right) >= k){
            return right;
        }
        if(pieces(L, left) >= k){
            return left;
        }
        
        
        return 0;
    }
    
    private int pieces(int[] L, int k){
        int res = 0;
        for(int i = 0; i < L.length; i++){
            res += L[i]/k;
        }
        return res;
    }
}