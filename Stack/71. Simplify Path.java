/*做梦也没想到需要用stack做*/
class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String res = "";
        for(String str : path.split("/")){
            if(str.equals("..") && !stack.isEmpty()){
                stack.pop();
            }
            if(str.equals(".") || str.equals("") || str.equals("..")){
                continue;
            }
            stack.push(str);
        }
        while(!stack.isEmpty()){
            res = "/" + stack.pop() + res;
        }
        return res.length() == 0 ? "/" : res;
    }
}