/*
start的时候push，end的时候pop
每次都要更新prev，end的时候prev要+1、res[]也是要+1
*/

class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if(logs.size() == 0){
            return new int[n];
        }
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int prev = Integer.parseInt(s[2]);
        
        for(int i=1; i < logs.size(); i++){
            String[] ss = logs.get(i).split(":");
            
            if(ss[1].equals("start")){
                if(!stack.isEmpty()){
                    res[stack.peek()] += Integer.parseInt(ss[2]) - prev;
                }
                stack.push(Integer.parseInt(ss[0]));
                prev = Integer.parseInt(ss[2]);
            }else{
                res[stack.peek()] += Integer.parseInt(ss[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(ss[2]) + 1;
                
            }   
        }
        return res;        
    }
}