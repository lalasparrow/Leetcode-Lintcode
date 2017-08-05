/*就是注意一下从后往前遍历。
如果从前往后遍历的话，在：之后的数字也会被push进去，
这样的话，peek出来的就不是最后答案了。
比如T?4:5，最后5的时候也要push进去，peek出来的是5，
而不是4。
*/

public class Solution {
    public String parseTernary(String expression) {
        Stack<Character> stack = new Stack<>();
        for(int i=expression.length() - 1;i>=0;i--){
            char ch = expression.charAt(i);
            if(!stack.isEmpty() && stack.peek() == '?'){
                stack.pop();
                char left = stack.pop();
                stack.pop();
                char right = stack.pop();
                if(ch == 'T'){
                    stack.push(left);
                }else{
                    stack.push(right);
                }
                
            }else{
                stack.push(ch);
            }
            
        }
        return stack.peek() + "";
        
    }
}