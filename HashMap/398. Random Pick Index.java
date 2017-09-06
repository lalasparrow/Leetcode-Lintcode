class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Random rnd;
    int[] nums;
    public Solution(int[] nums) {
        this.rnd = new Random();
        this.nums = nums;
        
        for(int i=0; i < nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], new ArrayList<>());
            }
            map.get(nums[i]).add(i);
        }
    }
    
    public int pick(int target) {
        int size = map.get(target).size();
        return map.get(target).get(rnd.nextInt(size));
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */