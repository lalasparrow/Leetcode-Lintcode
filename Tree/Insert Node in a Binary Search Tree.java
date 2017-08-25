/*
iteration和recrusion的解法在下面，要知道的是，绝对不可能insert在中间，
只能insert在叶子上

https://www.jiuzhang.com/solution/insert-node-in-binary-search-tree/
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
     * @param root: The root of the binary search tree.
     * @param node: insert this node into the binary search tree
     * @return: The root of the new binary search tree.
     */
    
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // write your code here
        if(root==null){
            return node;
        }
        if(root.val > node.val){
            root.left = insertNode(root.left, node);
        }
        else{
            root.right = insertNode(root.right, node);
        }
        
        return root;
    }
}