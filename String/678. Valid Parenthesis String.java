//concise version
class Solution {
    public boolean checkValidString(String s) {
        return helper(s, 0, 0);
    }
    private boolean helper(String s, int k, int count){
        if(count < 0){
            return false;
        }
        if(k==s.length()){
            return count==0;
        }
        if(s.charAt(k) == '('){
            return helper(s, k+1, count+1);
        }
        else if(s.charAt(k) == ')'){
            return helper(s, k+1, count-1);
        }
        else{
            return helper(s, k+1, count)||helper(s, k+1, count-1)||helper(s, k+1, count+1);
        }
    }
}




//自己写的..好粗糙..
class Solution {
    public boolean checkValidString(String s) {
        if(s == null || s.length() == 0){
            return true;
        }
        return helper(s, new char[]{'(', ')'});
        
    }
    
    private boolean helper(String s, char[] par){
        int count =0;
        int star = 0;
        for(int i=0; i < s.length(); i++){
            if(s.charAt(i) == par[0]){
                count++;
            }else if(s.charAt(i) == par[1]){
                count--;
            }
            else{
                star++;
            }
            if(count < 0 && star < Math.abs(count)){
                return false;
            }
            
        }
        if(star >= Math.abs(count)){
            if(par[0] == '('){
                StringBuilder sb = new StringBuilder(s);
                return helper(sb.reverse().toString(), new char[]{')', '('});
            }else{
                return true;
            }
            
            
        }
        return false;
        
    }
}