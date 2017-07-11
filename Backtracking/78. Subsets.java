/*别人总结的backtrack的问题集锦：
https://discuss.leetcode.com/topic/46159/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partitioning
*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return new ArrayList<>(new ArrayList<>());
        }
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        res.add(new ArrayList<>());
        for(int i=0;i<nums.length;i++){
            list.add(nums[i]);
            helper(res, list, nums, i);
            list.remove(list.size() - 1);
        }
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int[] nums, int index){
        if(list.size() <= nums.length){
            res.add(new ArrayList<Integer>(list)); 
        }
        for(int i=index + 1;i<nums.length;i++){
            list.add(nums[i]);
            helper(res, list, nums, i);
            list.remove(list.size() - 1);
        }
        
    }
    
}