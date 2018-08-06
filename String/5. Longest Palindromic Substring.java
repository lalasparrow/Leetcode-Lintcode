5. Longest Palindromic Substring

1. broce force（会超时）
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
            return s;
        }
        String res = "";
        int[] count = new int[256];
        int len = s.length();
        for(int i=1; i <= len; i++){
            for(int j=0; j < i; j++){
                String sub = s.substring(j, i);
                if(isValid(sub) && res.length() < sub.length()){
                    res = sub;
                }
            }
        }
        
        return res;
    }
    private boolean isValid(String str){
        if(str.length() <= 1){
            return true;
        }
        int left = 0;
        int right = str.length() - 1;
        while(left <= right){
            if(str.charAt(left) == str.charAt(right)){
                left++;
                right--;
            }
            else{
                return false;
            }
        }
        return true;
    }
}

2. 




