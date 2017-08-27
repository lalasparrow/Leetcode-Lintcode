/*
找到node之后，把右侧最小的，也就是第一个大于该node的点找出来，
然后把该点的值换掉，同时要递归把右侧第一个大于该node的点delete
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
     * @param value: Remove the node with given value.
     * @return: The root of the binary search tree after removal.
     */
 
    public TreeNode removeNode(TreeNode root, int value) {
        // write your code here
        if(root == null){
            return root;
        }
       
        if(root.val < value){
            root.right = removeNode(root.right, value);
        }
        else if(root.val > value){
            root.left = removeNode(root.left, value);
        }
        else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }
            TreeNode min = findmin(root.right);
            root.val = min.val;
            root.right = removeNode(root.right, root.val);
            
        }
        
        return root;
    }
    private TreeNode findmin(TreeNode root){
        if(root == null){
            return null;
        }
        while(root.left != null){
            root = root.left;
        }
        
        return root;
    }
}