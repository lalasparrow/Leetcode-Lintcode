/*注意:
1. start和end相同的情况，这样就不需要经过dict了
2. leetcode把输入dict变成list了，所以重新建立一个set把里面的值都加进去，这样contains的时候不会超时
3. 注意small和big的判断条件要和最后next的判断条件相同，否则的话，会出错
前面写的是beginSet.size() < endSet.size()，后面也要是这样，大于等于不要变。
原因是，我们每次从small set开始出发找下一个词，最后要把small set原来的那个set，
可能是beginSet或者是endSet，给变成next。找这个原来的set，需要同样的判断条件

*/


public class Solution {
    /**
      * @param start, a string
      * @param end, a string
      * @param dict, a set of string
      * @return an integer
      */
    public int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if(start.equals(end)){
            return 1;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        Set<String> visited = new HashSet<>();
        beginSet.add(start);
        endSet.add(end);
        visited.add(start);
        visited.add(end);
        int len = 1;
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            Set<String> small = beginSet.size() < endSet.size() ? beginSet : endSet;
            Set<String> big = beginSet.size() < endSet.size() ? endSet : beginSet;
            Set<String> next = new HashSet<>();
            len++;
            
            for(String str : small){
                for(int i=0;i<str.length(); i++){
                    for(char j='a'; j<= 'z'; j++){
                        StringBuilder sb = new StringBuilder(str);
                        sb.setCharAt(i, j);
                        String word = sb.toString();
                        if(big.contains(word)){
                            return len;
                        }
                        if(dict.contains(word) && !visited.contains(word)){
                            visited.add(word);
                            next.add(word);
                        }
                    }
                }
            }

            if(beginSet.size() < endSet.size()){
                beginSet = next;
            }else{
                endSet = next;
            }
        }
        return 0;
    }
}