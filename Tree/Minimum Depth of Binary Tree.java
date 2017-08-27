/*
1. 利用root == null的时候，这肯定是不算的，所以变成MAX_VALUE
2. 利用叶子的时候一定会计算一次min的特性，所以在叶子的时候，return 1
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
    /**
     * @param root: The root of binary tree.
     * @return: An integer.
     */

    public int minDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        
        return getMin(root);
    }
    private int getMin(TreeNode root){
        if(root == null){
            return Integer.MAX_VALUE;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
        
    }
}