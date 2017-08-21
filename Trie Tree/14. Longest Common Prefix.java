/**follow up用trie tree写
https://leetcode.com/problems/longest-common-prefix/solution/
用divide and conquer，如果每个string的长度是n，数组长度是m，
时间复杂度：O(m*n). T(n) = 2T(n/2) + O(m)
**/

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0){
            return "";
        }
        return helper(0, strs.length - 1, strs);
            
    }
    private String helper(int start, int end, String[] strs){
        if(start == end){
            return strs[start];
        }
        else{
            int mid = start + (end - start)/2;
            String left = helper(start, mid, strs);
            String right = helper(mid + 1, end, strs);
            System.out.println(left + " " + right);

            return find(left, right);
        }
        
        
    }
    private String find(String left, String right){
        int len = Math.min(left.length(), right.length());
        // System.out.println(left + " " + right);
        for(int i = 0; i < len; i++){
            if(left.charAt(i) != right.charAt(i)){
                return left.substring(0, i);
            }
        }
        return left.substring(0, len);
    }
    
}