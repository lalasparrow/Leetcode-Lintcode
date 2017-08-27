/*方法和之前的是一样的*/
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
     *@param inorder : A list of integers that inorder traversal of a tree
     *@param postorder : A list of integers that postorder traversal of a tree
     *@return : Root of a tree
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        // write your code here
        if(inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0){
            return null;
        }
        
        return helper(inorder, postorder, 0, postorder.length - 1, inorder.length - 1);
        
    }
    private TreeNode helper(int[] inorder, int[] postorder, int in_s, int post_s, int in_e){
        if(post_s<0||in_s>in_e){
            return null;
        }
        TreeNode root = new TreeNode(postorder[post_s]);
        int index = in_s;
        for(int i=in_s; i<=in_e;i++){
            if(postorder[post_s] == inorder[i]){
                index = i;
                break;
            }
        }
        int len_right = in_e - index;
        TreeNode left = helper(inorder, postorder, in_s, post_s - len_right - 1, index-1);
        TreeNode right = helper(inorder, postorder, index+1, post_s-1, in_e);
        root.left = left;
        root.right = right;
        return root;
    }
    
}