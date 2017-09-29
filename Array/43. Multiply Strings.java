/*
注意第一个for循环里面，是products[i+j+1] += d1*d2;
需要加上之前在里面的值
*/

class Solution {
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] products = new int[n+m];
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                int d1 = num1.charAt(i) - '0';
                int d2 = num2.charAt(j) - '0';                
                products[i+j+1] += d1*d2;
            }
        }
        int carry = 0;
        for(int i= products.length - 1; i >= 0; i--){
            int sum = carry + products[i];
            carry = sum/10;
            products[i] = sum%10;
        }
        StringBuilder sb = new StringBuilder();
        for(int num : products){
            sb.append(num);
        }
        int zero = 0;
        while(zero < sb.length() && sb.charAt(zero) == '0'){
            zero++;
        }
        
        return zero == sb.length() ? "0" :sb.toString().substring(zero);
    }
}