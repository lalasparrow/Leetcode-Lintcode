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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        helper(root);
        return res;
    }
    
    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
      
        int left = Math.max(0, helper(root.left));
        int right = Math.max(0, helper(root.right));
        
        res = Math.max(res, left + right + root.val);
        return Math.max(left, right) + root.val;
        
    }
}