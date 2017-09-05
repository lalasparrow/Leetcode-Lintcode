/*successor要找的是第一个比p大的数字，也就是他的右子树中最小的那个

predecessor要找的是第一个比p小的数字，也就是他的左子树中最大的那个

如果返回的是null的话，那么就是当前root本身。
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
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null){
            return null;
        }
        if(root.val <= p.val){
            return inorderSuccessor(root.right, p);
        }
        else{
            TreeNode left = inorderSuccessor(root.left, p);
            return left == null ? root : left;
        }        
    }
}

//predecessor
public TreeNode predecessor(TreeNode root, TreeNode p) {
	if (root == null)
		return null;
	if (root.val >= p.val) {
    	return predecessor(root.left, p);
    }
    else {
    	TreeNode right = predecessor(root.right, p);
    	return (right != null) ? right : root;
  }
}
