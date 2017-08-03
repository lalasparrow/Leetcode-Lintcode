/*Backtracking
为了避免重复，在backtracking的时候要避开曾经写进去的元素。
*/
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(res, list, nums);
        return res;
        
    }
    private void backtracking(List<List<Integer>> res, List<Integer> list, int[] nums){
        if(list.size() == nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i])){
                continue;
            }
            list.add(nums[i]);
            backtracking(res, list, nums);
            list.remove(list.size() - 1);            
        }        
    }
}