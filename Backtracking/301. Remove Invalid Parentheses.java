/*
这题写了第三遍，好像终于懂了点了，i之前的str肯定是少了一个par[1]的string。
所以只要从i之后递归就行。

因为())这种移开第一个)还是第二个)得到的答案都是一样的，所以remove的是离(最近的那个。

j==lastRemove可以避开j-1越界的情况，这个条件必须写在j-1之前
*/
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(res, s, 0, 0, new char[]{'(', ')'});        
        return res;
    }
    
    private void helper(List<String> res, String str, int lastRemove, int lastEnd, char[] par){
        int count = 0;
        for(int i=lastEnd; i < str.length(); i++){
            if(str.charAt(i) == par[0]){
                count++;
            }
            if(str.charAt(i) == par[1]){
                count--;
            }
            if(count >= 0){
                continue;
            }
            for(int j=lastRemove; j<=i; j++){
                if(str.charAt(j) == par[1]&&(j==lastRemove || str.charAt(j-1) != par[1])){
                    helper(res, str.substring(0, j) + str.substring(j+1, str.length()), j, i, par);
                }
            }
            return;
            
        }
        String newStr = new StringBuilder(str).reverse().toString();
        
        if(par[0] == '('){
            helper(res, newStr, 0, 0, new char[]{')', '('});
        }else{
            res.add(newStr);
        }
    }
}