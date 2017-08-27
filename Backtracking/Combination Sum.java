public class Solution {
    /**
     * @param candidates: A list of integers
     * @param target:An integer
     * @return: A list of lists of integers
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer> list = new ArrayList<>();
        helper(candidates, res, list, target, 0);
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
                helper(candidates, res, list, target - candidates[i], i);
                list.remove(list.size() - 1);
            }
        }
    }
    
}