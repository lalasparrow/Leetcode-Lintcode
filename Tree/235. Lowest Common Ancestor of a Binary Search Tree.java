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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }
        
        return helper(root, p, q);
    }
    private TreeNode helper(TreeNode node, TreeNode p, TreeNode q){
        int max = Math.max(p.val, q.val);
        int min = Math.min(p.val, q.val);
        if(node.val >= min && node.val <= max){
            return node;
        }
        else if(node.val < min){
            return helper(node.right, p, q);
        }else {
            return helper(node.left, p, q);   
        }
    
        
    }
    
}