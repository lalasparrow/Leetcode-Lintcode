class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int l = (len1 + len2 + 1)/2;
        int r = (len1 + len2 + 2)/2;
        return (getkth(nums1, 0, nums2, 0, l) + getkth(nums1, 0, nums2, 0, r))/2.0;
        
    }
    private double getkth(int[] nums1, int start1, int[] nums2, int start2, int k){
        if(start1 > nums1.length - 1){
            return nums2[start2 + k - 1];
        }
        if(start2 > nums2.length - 1){
            return nums1[start1 + k - 1]; 
        }
        if(k==1){
            return Math.min(nums1[start1], nums2[start2]);
        }
        
        int mid1 = (start1 + k/2 - 1) < nums1.length ? nums1[start1 + k/2 - 1] : Integer.MAX_VALUE;
        int mid2 = (start2 + k/2 - 1) < nums2.length ? nums2[start2 + k/2 - 1] : Integer.MAX_VALUE;
        
        if(mid1 < mid2){
            return getkth(nums1, start1 + k/2, nums2, start2,       k - k/2);
        }else{
            return getkth(nums1, start1      , nums2, start2 + k/2, k - k/2);
        }
        
    }
    
}