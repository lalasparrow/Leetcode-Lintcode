/*
注意：
1. 在helper里面，是用wordDict里面的单词作为依据开始找的，而不是根据string一个一个取substring
2. 返回的List<String>有几种情况，
    a. 后面的string是有的，一个或者多个
    b. 后面的string是没有的
    c. 最后到达了s的最长的范围，也就是那次调用dfs时，s是空的，这时候用返回null来表示
        这时候，应该去掉最后一个" "。也就是用返回的是不是null来判断是否加上" "。
a和b会执行同样的语句，map.put()还有return res这两句，所以不应该用sublist.size()来判断是否是最后一个，
即dfs最后一个s长度是0的情况。如果string是没有的，那么返回的sublist长度是0，也就是说，不会把答案加入res里面，
毕竟不会进入for循环。
因此，当长度是0的时候，返回null。就有了
        if(s.length() == 0){
            return null;
        }
这一句。

3. 用hashmap来避免重复搜索
*/
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<String, List<String>>());
    
    }
    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        
        List<String> res = new ArrayList<>();
        if(s.length() == 0){
            return null;
        }
        
        for(String word : wordDict){
            if(s.startsWith(word)){
                List<String> sublist = dfs(s.substring(word.length()), wordDict, map);
                if(sublist != null){
                    for(String str : sublist){
                        res.add(word + " " + str);
                    }
                }else{
                    res.add(word);
                }
            }
        }
        map.put(s, res);
        return res;
    }
    
}