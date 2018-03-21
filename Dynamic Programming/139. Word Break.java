1. 计算是否能够用dict里面的单词组成string
1) DP
时间复杂度：O(N^2)
空间复杂度：O(N)
思路：利用一维数组来判断当前位置之前的string，是否能够由dict里面的词构成
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }
        Set<String> dict = new HashSet<>();
        for(String str : wordDict){
            dict.add(str);
        }
        
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(dp[j] && dict.contains(s.substring(j, i))){
                    dp[i] = true;
                    //此处可以加个break;
                }
            }
        }
        return dp[s.length()];
    }
}



2) Recursion with memoization
时间复杂度：O(N^2)，因为第一次调用helper函数之后，进入他for循环之后，需要O(N^2)。之后的调用都是直接call hashset，所以只需要O(1)
思路：dict是把wordDict这个输入转化成set，把每次确定肯定没有的string放在set里。利用memoization。

class Solution {
    Set<String> dict = new HashSet<>();
    Set<String> set = new HashSet<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if(s == null || s.length() == 0){
            return true;
        }
        for(int i=0; i < wordDict.size(); i++){
            dict.add(wordDict.get(i));
        }
        
        return helper(s, 0);
    }
    private boolean helper(String s, int start){
        if(start == s.length()){
            return true;
        }
        if(set.contains(s.substring(start))){
            return false;
        }
        
        for(int i=start+1; i <= s.length(); i++){
            
            if(dict.contains(s.substring(start, i)) && helper(s, i)){
                return true;
            }
        }
        //把不能由dict组成的string加入set中
        set.add(s.substring(start));
        return false;
        
    }
}

