/**
*把已经加入到某个string的anagrams变成"#"，
*因为#不是一个字母，需要记得在判断anagrams的时候，
*把有#的string也去掉，return false。
*时间复杂度：O(N^2)，如果不详细计较string的长度的话
**/

public class Solution {
    /**
     * @param strs: A list of strings
     * @return: A list of strings
     */
    public List<String> anagrams(String[] strs) {
        // write your code here
        Map<String, List<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i=0;i<strs.length;i++){
            if(strs[i].equals("#")){
                continue;
            }
            List<String> list = new ArrayList<>();
            map.put(strs[i], list);
            for(int j= i + 1; j<strs.length;j++){
                if(isAnagram(strs[i], strs[j])){
                    map.get(strs[i]).add(strs[j]);
                    strs[j] = "#";
                }
            }
            
        }
        for(String key : map.keySet()){
            if(map.get(key).size() > 0){
                res.add(key);
                res.addAll(map.get(key));
            }
        }
        
        return res;
        
    }
    private boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length() || str2.equals("#") || str1.equals("#")){
            return false;
        }
        int[] count = new int[26];
        for(int i=0;i<str1.length(); i++){
            count[str1.charAt(i) - 'a']++;
            count[str2.charAt(i) - 'a']--;
        }
        
        for(int i=0;i<count.length;i++){
            if(count[i] != 0) {
                return false;
            }
        }
        return true;
    }
    
}