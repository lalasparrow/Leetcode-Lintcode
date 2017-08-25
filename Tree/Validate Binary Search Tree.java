/*既然BST有大小关系，那么就要知道和谁作比较，所以有了max和min
这里为了避免node里面有MAX_VALUE和MIN_VALUE的情况，所以用了Long
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
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        if(root == null){
            return true;
        }
        
        return helper(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    private boolean helper(TreeNode root, long max, long min){
        if(root == null){
            return true;
        }
        if(root.val < max && root.val > min){
            return helper(root.left, root.val, min) && helper(root.right, max, root.val);
        }
        return false;
    }
    
}

