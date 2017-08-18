/**
做题的思路没错，但是自己的代码太长太复杂了，应该想到加一个判断在for里面的..

**/

public class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i=num1.length() - 1, j=num2.length() -1; i>=0||j>=0||carry!=0;i--,j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int num = x + y + carry;
            sb.append(num%10);
            carry = num/10;
        }
        
        return sb.reverse().toString();
    }
}