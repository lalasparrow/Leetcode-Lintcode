class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0){
            return 0;   
        }
        String rpn = getRPN(s);
        return resolveRPN(rpn);
        
    }
    
    private String getRPN(String str){
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(char c : str.toCharArray()){
            if(Character.isDigit(c)){
                sb.append(c);
            }else{
                if(c == ' '){
                    continue;
                }
                sb.append(" ");
                while(!stack.isEmpty() && getPriority(stack.peek()) >= getPriority(c)){
                    sb.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }
        while(!stack.isEmpty()){
            sb.append(" ").append(stack.pop());
        }
        return sb.toString();
    }
    private int resolveRPN(String s){
        Stack<Integer> stack = new Stack<>();
        String[] strs = s.split(" ");
        
        for(String str : strs){
            if(str.equals("")){
                continue;
            }
            
            if(str.equals("+")){
                int i = stack.pop();
                int j = stack.pop();
                stack.push(i + j);                
            }
            else if(str.equals("-")){
                int i = stack.pop();
                int j = stack.pop();
                stack.push(j - i);
            }
            else if(str.equals("*")){
                int i = stack.pop();
                int j = stack.pop();
                stack.push(i * j);
            }
            else if(str.equals("/")){
                int i = stack.pop();
                int j = stack.pop();
                stack.push(j / i);
            }
            else {
                stack.push(Integer.valueOf(str));
            }   
        }
        return stack.pop();
    }
    
    
    
    private int getPriority(char c){
        if(c == '-' || c == '+'){
            return 2;
        }else if(c == '*' || c == '/'){
            return 3;
        }
        return 0;
    }
    
}