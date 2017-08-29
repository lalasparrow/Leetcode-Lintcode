public class Solution {
    /*
     * @param nums: A list of integers
     * @return: the median of numbers
     */
    public int[] medianII(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return nums;
        }
        PriorityQueue<Integer> minStack = new PriorityQueue<>();
        PriorityQueue<Integer> maxStack = new PriorityQueue<>(nums.length, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return b - a;
            }
            
        });
        
        int[] res = new int[nums.length];
        for(int i=0; i < nums.length; i++){
            maxStack.offer(nums[i]);
            minStack.offer(maxStack.poll());
            if(minStack.size() > maxStack.size()){
                maxStack.offer(minStack.poll());
            }
            res[i] = maxStack.peek();
        }
        
        return res;
        
    }
}