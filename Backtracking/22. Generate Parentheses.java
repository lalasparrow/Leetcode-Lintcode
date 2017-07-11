/*这题也是用backtracking，但是不同的是，里面的backtracking是用在括号上面的。
要保证括号的一致性，两边数目一致，并且都是一对一对的。
那么这就helper function需要记录下左括号和右括号的数目。
*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        if(n <= 0){
            return new ArrayList<String>();
        }
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        backtracking(res, n, sb, 0, 0);
        return res;
    }
    private void backtracking(List<String> res, int n, StringBuilder sb, int left, int right){
        if(left == n && right == n){
            res.add(sb.toString());
            return;
        }
        if(left < n){
            sb.append("(");
            backtracking(res, n, sb, left + 1, right);
            sb.setLength(sb.length() - 1);
        }
        if(right < left){
            sb.append(")");
            backtracking(res, n, sb, left, right + 1);
            sb.setLength(sb.length() - 1);
        }
        
    }
    
}