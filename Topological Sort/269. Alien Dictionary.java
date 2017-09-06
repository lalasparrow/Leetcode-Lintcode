/*
题目读了好久都没读懂。
意思是这样的，现在有个alien dictionary，和普通的按字母a-b-c..排序的dictionary不同，他的顺序要通过给的String[]来找。单个单词之间的字母顺序没有任何意义。相邻的单词的顺序才有意义。

所以其实就是topological sort。从a'->b'->..一直找

使用一个inDegree记录入度，另一个map记录后面的node(char)。

注意各种map.containsKey还有map中的set是否已经有了c2。有了之后不要重复添加inDegree
*/

class Solution {
    public String alienOrder(String[] words) {
        if(words == null || words.length == 0){
            return "";
        }
        String res = "";
        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, Set<Character>> map = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                inDegree.put(c, 0);
            }
        }
        
        for(int i=0; i < words.length - 1; i++){
            String word1 = words[i];
            String word2 = words[i+1];
            for(int j=0; j < Math.min(word1.length(), word2.length()); j++){
                char c1 = word1.charAt(j);
                char c2 = word2.charAt(j);
                if(c1 != c2){                    
                    if(!map.containsKey(c1)){
                        map.put(c1, new HashSet<>());
                    }
                    if(!map.get(c1).contains(c2)){
                        map.get(c1).add(c2);
                        inDegree.put(c2, inDegree.get(c2) + 1);   
                    }           
                    break;
                }
            }
        }
        
        Queue<Character> q = new LinkedList<>();
        for(char key : inDegree.keySet()){
            if(inDegree.get(key) == 0){
                q.add(key);
            }
        }
        
        while(!q.isEmpty()){
            char ch = q.poll();
            res += ch;
            if(map.containsKey(ch)){
                for(char c : map.get(ch)){
                    inDegree.put(c, inDegree.get(c) - 1);
                    if(inDegree.get(c) == 0){
                        q.add(c);
                    }
                }
            }
            
        }
        if(res.length() != inDegree.size()){
            return "";
        }
        return res;
    }
}