class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0){
            return res;
        }
        Map<String, List<String>> map = new HashMap<>();
        
        for(String str : strs){
            char[] newStr = str.toCharArray();
            Arrays.sort(newStr);
            String s = Arrays.toString(newStr);
            if(!map.containsKey(s)){
                map.put(s, new ArrayList<>());
            }
            map.get(s).add(str);
        }
        for(String str : map.keySet()){
            res.add(map.get(str));
        }
        return res;
        
    }
}