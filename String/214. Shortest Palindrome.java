/*
0~left的是可能出现palindrome的最大的长度，由此递归。
*/

class Solution {
    public String shortestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        int left = 0;
        for(int right = s.length() - 1; right >=0; right--){
            if(s.charAt(right) == s.charAt(left)){
                left++;
            }
        }
        if(left == s.length()){
            return s;
        }
        String str = s.substring(left);
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString() + shortestPalindrome(s.substring(0,left)) + str;
    }
}