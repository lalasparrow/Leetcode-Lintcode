/*用递增stack来存数字，因为如果当前的height比之前的要小，之前的height最长只能拓展到当前的index了。
注意：
1. stack存的index
2. 计算w的时候，是拿pop之后的stack.peek()来计算，因为中间可能隔着几个高的，这样index就可以拓展出去
3. stack有可能为空，过了最后一个height之后，也可能有max area，因此for循环的范围是0~height.length
*/
public class Solution {
    /*
     * @param height: A list of integer
     * @return: The area of largest rectangle in the histogram
     */
    public int largestRectangleArea(int[] height) {
        // write your code here
        if(height == null || height.length == 0){
            return 0;
        }
        
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for(int i=0; i <= height.length; i++){
            int cur = i==height.length ? -1 : height[i];
            while(!stack.isEmpty() && height[stack.peek()] >= cur){
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h*w);
            }
            
            stack.push(i);
        }
        return max;
    }
}