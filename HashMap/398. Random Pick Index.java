/*
 For the nth target, ++count is n. Then the probability that rnd.nextInt(++count)==0 is 1/n. Thus, the probability that return nth target is 1/n.
 For (n-1)th target, the probability of returning it is (n-1)/n * 1/(n-1)= 1/n.
 
 */
//count用来记录当前的target的数量

public class Solution {
    
    int[] nums;
    Random rnd;
    
    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }
    
    public int pick(int target) {
        int result = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target)
                continue;
            if (rnd.nextInt(++count) == 0)//random出来是0的情况
                                        //对于下一个数字，需要保证这一个不取，下一个取，所以才会是(n-1)/n * 1/(n-1) = 1/n
                result = i;
        }
        
        return result;
    }
}
