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
    public int closestValue(TreeNode root, double target) {
        int val = root.val;
        
        while(root != null){
            if(Math.abs(val - target) > Math.abs(root.val - target)){
                val = root.val;
            }
            
            root = root.val > target ? root.left : root.right;
        }
        return val;
    }
}