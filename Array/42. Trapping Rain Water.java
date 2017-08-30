class Solution {
    public int trap(int[] height) {
        if(height == null || height.length <= 2){
            return 0;
        }
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        while(left < right){
            if(leftMax < rightMax){
                while(left < right && height[left] <= leftMax){
                    res += leftMax - height[left];
                    left++;
                }
                leftMax = Math.max(height[left], leftMax);
                
            }else{
                while(left < right && height[right] <= rightMax){
                    res += rightMax - height[right];
                    right--;
                }
                rightMax = Math.max(height[right], rightMax);
            }
        }
        
        return res;
    }
}