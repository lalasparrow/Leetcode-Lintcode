/**
题目有两种做法：
1. 两个string转化成array之后sort，看得到的结果是不是一样的
时间复杂度：O(NlogN)
2. 还有一种常用的计算每个字母出现次数是否相同的做法，在lintcode里面，
"happy new year", "n ahwryeypp ea" 这个test case，需要将计数数组的容量变成256。
因为有空格。然后不再- 'a'
时间复杂度：O(N)
**/

public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
        return false;
    }
    int[] counter = new int[26];
    for (int i = 0; i < s.length(); i++) {
        counter[s.charAt(i) - 'a']++;
        counter[t.charAt(i) - 'a']--;
    }
    for (int count : counter) {
        if (count != 0) {
            return false;
        }
    }
    return true;
}