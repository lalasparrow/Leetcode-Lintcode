/*首先要想明白的是：
	1. 计算left的rain，还是计算right的rain
	2. 计算的时候肯定是做差，那么是和谁左查
	3. 什么时候需要最差呢
1. 用leftMax和rightMax来比较，谁更小，就计算哪边。这样做的好处是，
避免当left和right同时计算这个坑的rain的时候，能够使用更小的那边来计算，避免错误。
2. 使用两个变量leftMax和rightMax来做差，计算rain的个数
3. 当当前的数字比max要大的时候，当然就不用左差。但是要注意，要更新max并且要注意越界。
*/

public class Solution {
    public int trap(int[] height) {
    	if(height == null || height.length <= 2)
    		return 0;

    	int left = 0;
    	int right = height.length - 1;
    	int leftMax = height[left];
    	int rightMax = height[right];
    	int res = 0;

    	while(left < right){

    		if(leftMax < rightMax){
	    		if(left + 1 < height.length && height[left + 1] < leftMax){
	    			res += leftMax - height[left + 1];
	    		}
	    		left++;
	    		leftMax = Math.max(leftMax, height[left]);

	    	}else{
	    		if(right - 1 < height.length && height[right - 1] < rightMax){
	    			res += rightMax - height[right - 1];
	    		}
	  			right--;
	  			rightMax = Math.max(rightMax, height[right]);

	    	}


    	}

    	

    	return res;
    }

}