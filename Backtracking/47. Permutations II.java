/*Backtracking
因为这次nums里面的数字有重复，所以，先sort，之后遇到重复的避过去即可。
*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        backtracking(res, list, nums, new boolean[nums.length]);
        return res;
        
    }
    private void backtracking(List<List<Integer>> res, List<Integer> list, int[] nums, boolean[] used){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(i>=1 && nums[i] == nums[i-1] && used[i-1] == true || used[i] == true){
                continue;
            }
            
            list.add(nums[i]);
            used[i] = true;
            backtracking(res, list, nums, used);
            list.remove(list.size() - 1);
            used[i] = false;
            
        }        
    }
}