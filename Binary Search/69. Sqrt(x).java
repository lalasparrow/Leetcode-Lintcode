/*
因为返回的值是int，所以他的平方可能是long，因此要转换int -> long
*/

class Solution {
    public int mySqrt(int x) {
        if(x < 0){
            return x;
        }
        long left = 0;
        long right = x;
        while(left <= right){
            long mid = left + (right - left)/2;
            if(mid*mid == x){
                return (int)mid;
            }else if(mid*mid > x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        
        return (int)right;
    }
}