/*
判断的时候要用除法，不要用mid*mid == x，用乘法的话，只有正好等于的时候才会return
*/

public class Solution {
    /*
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        if(x <= 0){
            return 0;
        }
        int left = 1;
        int right = x;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(mid == x/mid){
                return mid;
            }
            else if(mid < x/mid){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
            
            
        }
        // System.out.println(left + " " + right);
        return right;
    }
}