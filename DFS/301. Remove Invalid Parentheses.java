/*看答案都看了很久..
用stack这个变量记录括号数目对不对等，如果左边括号多，就继续循环，
右边括号多的话，就需要将第一个右侧括号减掉，然后递归。
将第一个右侧括号减掉的原因是，"())"这种情况，删除第一个)或者第二个),
都能得到一样的结果。所以为了避免重复的情况，只删除第一个即可。
第30行的判断，如果不加上j==last_j的话，"))"这种情况在j-1的时候会outofbound。

最后将整个数组reverse，然后从反方向，把(多出来的情况也删掉。
*/

public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();       
        remove(res, 0, 0, s, new char[]{'(', ')'});
        return res;
        
    }
    private void remove(List<String> ans, int last_i, int last_j, String s, char[] par){
        for(int stack = 0, i=last_i; i< s.length(); i++){
            if(s.charAt(i) == par[0]){
                stack++;
            }
            if(s.charAt(i) == par[1]){
                stack--;
            }
            if(stack >= 0){
                continue;
            }
            for(int j = last_j; j <= i; j++){
                if(s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])){
                    remove(ans, i, j, s.substring(0, j) + s.substring(j+1, s.length()), par);
                }
            }
            return;
        }
        StringBuilder sb = new StringBuilder(s);
        String reversed  = sb.reverse().toString();
        if(par[0] == '('){
            remove(ans, 0, 0, reversed, new char[]{')', '('});
        }else{
            ans.add(reversed);
        }
        
    }
}