class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0;
        int right = 0;
        int res = 0;
        while(right < n){
            if(map.size() <= 2){
                map.put(s.charAt(right), right);
                right++;
            }
            
            if(map.size() > 2){
                int min = Integer.MAX_VALUE;
                for(int i : map.values()){
                    min = Math.min(min, i);
                }
                map.remove(s.charAt(min));
                left = min+1;
            }
            res = Math.max(res, right - left);
        }
        
        return res;
    }
}