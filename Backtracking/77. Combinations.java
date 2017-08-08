/*backtracking
其实有更简单的判断(https://discuss.leetcode.com/topic/11718/backtracking-solution-java/8)
就是for循环的终点是n-k+1，每次不仅要更新起点，还要更新终点


*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(ans, new ArrayList<Integer>(), k, 1, n-k+1);
        return ans;
    }

    private void dfs(List<List<Integer>> ans, List<Integer> list, int kLeft, int from, int to) {
        if (kLeft == 0) { ans.add(new ArrayList<Integer>(list)); return; }
        for (int i=from; i<=to; ++i) {
            list.add(i);
            dfs(ans, list, kLeft-1, i+1, to+1);
            list.remove(list.size()-1);
        }
    }
}

/*my solution*/
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k<=0 || n<=0){
            return res;
        }
        helper(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }
    private void helper(List<List<Integer>> res, List<Integer> list, int k, int n, int index){
        if(list.size() == k){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=index; i <= n; i++){
            if(!list.contains(i)){
                if(list.size() >= 1 && list.get(list.size() - 1) < i || list.size() == 0){
                    list.add(i);
                    helper(res, list, k, n, index+1);
                    list.remove(list.size() - 1);
                }
                
            }
            
        }
        
    }
}