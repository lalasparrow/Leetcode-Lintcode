/*基础题..
要记得要左右都isBalanced一下
*/

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
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if(root == null){
            return true;
        }
        int left = height(root.left);
        int right = height(root.right);
        
        return Math.abs(left-right) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        
    }
    public int height(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = height(root.left) + 1;
        int right = height(root.right) + 1;
        return Math.max(left, right);
    }
}