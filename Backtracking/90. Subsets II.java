class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, 0, nums, new ArrayList<>());
        return res;
    }
    
    private void helper(List<List<Integer>> res, int start, int[] nums, List<Integer> list){
        if(!res.contains(list) && start <= nums.length){
            res.add(new ArrayList<Integer>(list));
        }
        for(int i=start; i < nums.length; i++){
            list.add(nums[i]);
            helper(res, i+1, nums, list);
            list.remove(list.size() - 1);
        }
        
        
    }
}