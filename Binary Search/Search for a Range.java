public class Solution {
    /*
     * @param A: an integer sorted array
     * @param target: an integer to be inserted
     * @return: a list of length 2, [index1, index2]
     */
    public int[] searchRange(int[] A, int target) {
        // write your code here
        int[] res = new int[]{-1,-1};
        if(A == null || A.length == 0){
            return res;
        }
        
        int left = 0;
        int right = A.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(A[mid] == target){
                int start = mid;
                int end = mid;
                while(start>=1 && A[start-1] == target){
                    start--;
                }
                while(end<A.length-1&&A[end+1] == target){
                    end++;
                }
                res[0] = start;
                res[1] = end;
                return res;
            }
            else if(A[mid] < target){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
            
        }
        return res;
    }
}