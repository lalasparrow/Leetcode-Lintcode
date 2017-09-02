/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0, res, root);
        return res;
    }
    private void helper(int level, List<List<Integer>> res, TreeNode root){
        if(root == null){
            return;
        }
        if(level >= res.size()){
            res.add(new ArrayList<>());
        }
        
        res.get(level).add(root.val);
        
        helper(level + 1, res, root.left);
        helper(level + 1, res, root.right);
        
    }
}