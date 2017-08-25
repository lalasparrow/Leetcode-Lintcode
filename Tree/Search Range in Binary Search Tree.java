/*依旧是利用BST特性的一道题
如果顺序是inorder的话，就不用sort了
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
     * @param root: param root: The root of the binary search tree
     * @param k1: An integer
     * @param k2: An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        
        if(k1>k2 || root == null){
            return res;
        }
        helper(res, k1, k2, root);
        Collections.sort(res);
        return res;
    }
    private void helper(List<Integer> res, int k1, int k2, TreeNode root){
        if(root == null){
            return;
        }
        if(root.val <= k2 && root.val >= k1){
            res.add(root.val);
            helper(res, k1, k2, root.left);
            helper(res, k1, k2, root.right);
        }
        else if(root.val > k2){
            helper(res, k1, k2, root.left);
        }
        else if(root.val < k1){
            helper(res, k1, k2, root.right);
        }
        
    }
    
    
    
}