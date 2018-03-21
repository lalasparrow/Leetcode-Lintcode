3. Longest Substring Without Repeating Characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int len = s.length();
        int res = 0;
        
        Set<Character> set = new HashSet<>();
        int right = 0;
        for(int i=0; i < len; i++){
            while(i <= right && right < len && !set.contains(s.charAt(right))){
                set.add(s.charAt(right++));
            }
                  
            if(right - i > res){
                res = right - i;
            }      
            set.remove(s.charAt(i));
        
        }
        
        return res;
        
    }
}

