/*
注意：
1. charAt(i)是0的情况，0是在pos还是在别的地方。"05"不是一个数字，因此如果i!=pos&&num.charAt(pos) == '0'的话，要break，同时也避免了00这种，00会只取一次0。
2. 遇到乘法的时候有优先级问题，需要保存上一次的结果。如果这次是用的乘法的话，那么需要减去上一次的，然后将lastAdd变成上一次乘上这一次的值，就是当做是再做一次加减（在上一次加减之后），避开做乘法的过程。
3. 用long存储结果，避免overflow的问题
*/
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if(num == null || num.length() == 0){
            return res;
        }
        helper(res, "", 0, target, num, 0, 0);
        return res;
    }
    private void helper(List<String> res, String str, int pos, int target, String num, long curResult, long lastAdd){
        if(pos == num.length() && curResult == target){
            res.add(str);
            return;
        }
        for(int i=pos; i < num.length(); i++){
            if(i != pos && num.charAt(pos) == '0'){
                break;
            }
            long cur = Long.valueOf(num.substring(pos, i+1));
            if(pos == 0){
                helper(res, str + cur, i + 1, target, num, cur, cur);
            }else{
                helper(res, str + "-" + cur, i + 1, target, num, curResult - cur, -cur);
                helper(res, str + "+" + cur, i + 1, target, num, curResult + cur, cur);
                helper(res, str + "*" + cur, i + 1, target, num, curResult - lastAdd + lastAdd*cur, lastAdd*cur);
            }
            
        }
        
    }
    
}
