/*利用长度更好做..就不用两个for循环慢慢找了..
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
     *@param preorder : A list of integers that preorder traversal of a tree
     *@param inorder : A list of integers that inorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // write your code here
        if(preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0){
            return null;
        }
        return helper(preorder, inorder, 0, 0, inorder.length - 1);
    }
    private TreeNode helper(int[] preorder, int[] inorder, int pre_s, int in_s, int in_e){
        if(in_s>in_e||pre_s>=preorder.length){
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[pre_s]);
        int in_root = 0;
        for(int i=in_s;i<=in_e; i++){
            if(inorder[i] == preorder[pre_s]){
                in_root = i;
                break;
            }
        }
        int left_length = in_root - in_s;
        int right_length = in_e - in_s;
        root.left = helper(preorder, inorder, pre_s+1, in_s, in_root-1);
        root.right = helper(preorder, inorder, pre_s+left_length+1, in_root+1, in_e);
        return root;
    }
    
}