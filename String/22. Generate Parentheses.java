/*注意str = str.substring()
*/
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        
        helper(res, n, "", 0, 0);
        return res;
    }
    
    private void helper(List<String> res, int n, String str, int left, int right){
        if(right == left && left == n){
            res.add(new String(str));
            return;
        }
        
        if(left < n){
            int len = str.length();
            str += "(";
            helper(res, n, str, left + 1, right);
            str = str.substring(0, len);
        }
        if(right < left){
            int len = str.length();
            str += ")";
            helper(res, n, str, left, right + 1);
            str = str.substring(0, len);
        }
        
    }
}