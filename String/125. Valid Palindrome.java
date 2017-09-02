class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() <= 1){
            return true;
        }
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left <= right){
            while(left < right && !Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left < right && !Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
            
        }
        return true;
    }
}