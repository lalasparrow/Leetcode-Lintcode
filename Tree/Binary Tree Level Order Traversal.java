/*把level和res的size建立起联系*/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param root: A Tree
     * @return: Level order a list of lists of integer
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        helper(0, res, root);
        return res;
    }
    private void helper(int level, List<List<Integer>> res, TreeNode root){
        if(root == null){
            return;
        }
        List<Integer> list = new ArrayList<>();
        if(level < res.size()){
            list = res.get(level);
            list.add(root.val);
            res.set(level, list);
        }else{
            list.add(root.val);
            res.add(list);   
        }
        
        helper(level + 1, res, root.left);
        helper(level + 1, res, root.right);
    }
    
}