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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(res, root, "");
        return res;
    }
    private void helper(List<String> res, TreeNode root, String str){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            res.add(str + root.val);
            return;
        }
       
        
        str = str + root.val + "->";
        
        helper(res, root.left, str);
        helper(res, root.right, str);
        
    }
    
}