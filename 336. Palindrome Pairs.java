/*这题要想到，不仅仅只有两个连起来变成一个palindrome，
更有可能某个string的前一半是palindrome，另一个string把它的后面连起来变成palindrome。
嵌套的第二个for循环可以想成是长度，这样需要长度切在[0, length]之间。
要注意第二个if里面条件str2.length() != 0，这样可以避免重复的情况。
还要注意加入list的顺序，想清楚关系就没事。
*/

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> res = new ArrayList<>();
        if (words == null || words.length < 2) return res;
        Map<String, Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i], i);
        }
        
        for(int i = 0; i<words.length; i++){
            for(int j=0;j<=words[i].length();j++){
                String str1 = words[i].substring(0,j);
                String str2 = words[i].substring(j);
                if(isPalin(str1)){
                    String str2rev = new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(str2rev) && map.get(str2rev) != i){
                        List<Integer> list = new ArrayList<>();
                        list.add(map.get(str2rev));
                        list.add(i);
                        res.add(list);
                    }
                  
                }
                if(isPalin(str2)){
                    String str1rev = new StringBuilder(str1).reverse().toString();
                    if(map.containsKey(str1rev) && map.get(str1rev) != i && str2.length() != 0){
                        List<Integer> list = new ArrayList<>();
                        list.add(i);
                        list.add(map.get(str1rev));
                        res.add(list);
                    }
                }
                
            }
        }
        return res;
    }
    
    private boolean isPalin(String str){
        int left = 0;
        int right = str.length() - 1;
        while(left <= right){
            if(str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }
}