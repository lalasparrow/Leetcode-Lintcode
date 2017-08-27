public class Solution {
    /**
     * @param num: Given the candidate numbers
     * @param target: Given the target number
     * @return: All the combinations that sum to target
     */
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(num);
        List<Integer> list = new ArrayList<>();
        helper(num, res, list, target, 0);
        return res;   
    }
    private void helper(int[] candidates, List<List<Integer>> res, List<Integer> list, int target, int start){
        if(target == 0 && !res.contains(list)){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            if(candidates[i] <= target){
                list.add(candidates[i]);
                helper(candidates, res, list, target - candidates[i], i+1);
                list.remove(list.size() - 1);
            }
        }
    }
}