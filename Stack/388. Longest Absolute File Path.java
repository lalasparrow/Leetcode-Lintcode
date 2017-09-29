/*
因为计算length的时候，要peek stack，所以，对于第一个来说，需要一个0。因此提前push进stack一个0。
计算长度的时候，因为需要补上"/"，因此是-level+1


*/


class Solution {
    public int lengthLongestPath(String input) {
        int res = 0;
        if(input == null || input.length() == 0){
            return res;
        }
        String[] strs = input.split("\n");
        
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        for(String str : strs){
            int level = str.lastIndexOf("\t")+1;
            while(stack.size() > level+1){
                stack.pop();
            }
            int len = stack.peek() + str.length() - level + 1;
            stack.push(len);
            
            if(str.indexOf(".") != -1){
                res = Math.max(res, len - 1);
            }            
        }
        
        return res;
    }
   
}