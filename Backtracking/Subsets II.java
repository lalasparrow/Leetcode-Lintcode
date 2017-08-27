public class Solution {
    /*
     * @param nums: A set of numbers.
     * @return: A list of lists. All valid subsets.
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, nums, 0, new ArrayList<Integer>());
        return res;
    }
    private void helper(List<List<Integer>> res, int[] nums, int start, List<Integer> list){
        if(start > nums.length){
            return;
        }
        if(!res.contains(list)){
            res.add(new ArrayList<Integer>(list));
        }
        for(int i=start; i<nums.length; i++){
            
            list.add(nums[i]);
            helper(res, nums, i+1, list);
            list.remove(list.size() - 1);
        }
    }
}