/*注意：
1. findKth这个方法是找的第k个元素，所以传入的int k是第k个。
因此，当要找数组中的数字的时候，需要-1
2. 这道题的思路是：两个sorted arrays的median，肯定也是两个拆一半的median。
当nums1的median大于nums2的median的时候，那么说明，整个数组的median肯定在nums1的左边+nums的右边，
所以组成新的sorted array找median。
否则，整个数组的median肯定在nums1的右边+nums2的左边，这样组成新的sorted array找median
*/

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        if(len%2 == 1){
            return findKth(nums1, 0, nums2, 0, len/2 + 1);
        }else{
            return (findKth(nums1, 0, nums2, 0, len/2) + findKth(nums1, 0, nums2, 0, len/2 + 1))/2.0;
        }
    }
    //find kth number of sorted array
    private int findKth(int[] nums1, int start1, int[] nums2, int start2, int k){
        if(start1 >= nums1.length){
            return nums2[start2 + k - 1];
        }
        if(start2 >= nums2.length){
            return nums1[start1 + k - 1];
        }
        if(k == 1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        int mid1 = start1 + k/2 - 1 < nums1.length ? nums1[start1 + k/2 - 1] : Integer.MAX_VALUE;
        int mid2 = start2 + k/2 - 1 < nums2.length ? nums2[start2 + k/2 - 1] : Integer.MAX_VALUE;
        if(mid1 > mid2){
            return findKth(nums1, start1, nums2, start2 + k/2, k - k/2);
        }else{
            return findKth(nums1, start1 + k/2, nums2, start2, k - k/2);
        }
        
        
    }
    
    
}