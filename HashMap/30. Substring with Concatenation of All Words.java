/*注意循环开始的点，还有break的地方。
*/

public class Solution {
   public List<Integer> findSubstring(String s, String[] words) {
       List<Integer> res = new ArrayList<>();
       Map<String, Integer> map = new HashMap<>();
       for(String word : words){
           map.put(word, map.getOrDefault(word, 0) + 1);
       }
       int m = words[0].length();
       int n = words.length;
       for(int i=0;i<=s.length() - m*n; i++){
           Map<String, Integer> copy = new HashMap<>(map);
           int k = n;
           int j = i;
           while(k > 0){
               String str = s.substring(j, j + m);

               if(copy.containsKey(str) && copy.get(str) >= 1){
                   int val = copy.get(str);
                   copy.put(str, val - 1);
               }else{
                   break;
               }
               k--;
               j+=m;
               
           }
           if(k == 0){
               res.add(i);
           }
           
       }
       
       
       return res;
   }
}