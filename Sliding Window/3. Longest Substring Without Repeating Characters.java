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



class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>(); // char : index pairs
        int res = 0;
        for(int left = 0, right = 0; right < s.length(); right++){
            if(map.containsKey(s.charAt(right))){
                left = Math.max(left, map.get(s.charAt(right)) + 1);
            }
            
            res = Math.max(res, right - left + 1);            
            map.put(s.charAt(right), right);
        }
        return res;
    }
}
