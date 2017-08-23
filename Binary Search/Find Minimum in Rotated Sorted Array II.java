/*
用hi--是因为array由小到大排列的，如果lo++会漏掉数字
*/

public class Solution {
    /**
     * @param num: a rotated sorted array
     * @return: the minimum number in the array
     */
    public int findMin(int[] num) {
        // write your code here
        if(num == null || num.length < 1){
            return 0;
        }
        int left = 0;
        int right = num.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left)/2;
            
            if(num[right] < num[mid]){
                left = mid;
            }
            else if(num[mid] < num[right]){
                right = mid;
            }else{
                right--;
                
            }
        }
        return Math.min(num[left], num[right]);
    }
}