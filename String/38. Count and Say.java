class Solution {
    public String countAndSay(int n) {
        if(n <= 1){
            return "1";
        }
        
        String res = "";
        String prevRes = "1";
        int i = 2;
        while(i <= n){
            int count = 0;
            while(count < prevRes.length()){
                char c = prevRes.charAt(count);
                int num = 0;
                while(count < prevRes.length() && c == prevRes.charAt(count)){
                    count++;
                    num++;
                }
                res += String.valueOf(num) + String.valueOf(c);
                
            } 
            prevRes = res;
            res = "";
            i++;
        }
        return prevRes;
    }
}