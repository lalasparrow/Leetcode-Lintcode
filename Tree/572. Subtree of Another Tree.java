/*
一个函数用于判断是否相同，另一个函数用于判断哪两个子树作为输入
*/

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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null){
            return false;
        }
        if(helper(s, t)){
            return true;
        }
        
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }
    private boolean helper(TreeNode s, TreeNode t){
        if(s == null && t != null || s != null && t == null){
            return false;
        }
        if(s == null && t == null){
            return true;
        }
        if(s.val != t.val){
            return false;
        }
        
        return helper(s.left, t.left) && helper(s.right, t.right);
    }
}