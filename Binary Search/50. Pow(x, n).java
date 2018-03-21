/*
如果n是MIN_VALUE的话，如果直接变成-n，不会变成MAX_VALUE，依旧是MIN_VALUE。因此+2，+2不改变奇偶性还有正负。
n是MAX_VALUE的话没什么事。
 Integer.MIN_VALUE = -2147483648
 Integer.MAX_VALUE = 2147483647
 -Inetger.MIN_VALUE = -2147483648
 -Integer.MAX_VALUE = 2147483647
*/

class Solution {
    public double myPow(double x, int n) {
        if(x == 0){
            return 0;
        }
        else if(n == 0){
            return 1;
        }
        
        if(n == Integer.MIN_VALUE){
            n += 2;
        }
        
        if(n<0) {
            n = -n;
            x = 1/x;
        }
        
        if(n%2 == 0){
            return myPow(x*x,n/2);
        }else{
            return myPow(x*x, n/2)*x;
        }        
    }
}
