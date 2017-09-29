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
    public int kthSmallest(TreeNode root, int k) {
        if(root == null){
            return 0;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        int i = 0;
        while(k!=0){
            cur = stack.pop();
            k--;
            if(k==0){
                return cur.val;
            }
            
            if(cur.right != null){
                cur = cur.right;
                while(cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }
            }
            
            
        }
        return -1;
        
    }
}

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
    public int kthSmallest(TreeNode root, int k) {
        
        int c = count(root.left);
        
        if(c >= k){
            return kthSmallest(root.left, k);
        }
        else if(c + 1 < k){
            return kthSmallest(root.right, k - c - 1);
        }
        
        return root.val;
        
    }
    private int count(TreeNode root){
        if(root == null){
            return 0;
        }
        return count(root.left) + count(root.right) + 1;
    }
}