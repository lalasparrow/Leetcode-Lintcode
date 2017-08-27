/*注意start和end相同的情况，这样就不需要经过dict了*/
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