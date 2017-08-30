class Solution {
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length == 0){
            return digits;
        }
        int i = digits.length - 1;
        int carry = 0;
        while(i>=0 && digits[i] == 9){
            digits[i] = 0;
            carry = 1;
            i--;
        }
        int[] res = new int[digits.length + 1];
        if(i>=0){
            digits[i] += 1;
        }else{   
            res[0] = 1; 
        }
        return i < 0 ? res : digits;
        
        
    }
}