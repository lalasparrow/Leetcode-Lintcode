/*non-recursion的方法也要掌握

https://www.jiuzhang.com/solution/binary-tree-preorder-traversal
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
     * @param root: A Tree
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        helper(res, root);
        return res;
    }
    private void helper(List<Integer> res, TreeNode root){
        if(root == null){
            return;
        }
        res.add(root.val);
        helper(res, root.left);
        helper(res, root.right);
        
    }
    
}