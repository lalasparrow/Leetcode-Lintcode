/*确定叶子节点要让他左右都是null，确定是左叶子节点就需要从root.left看。*/

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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int sum = 0;
        if(root.left != null){
            if(root.left.left == null && root.left.right == null){
                sum += root.left.val;
            }
            else{
                sum += sumOfLeftLeaves(root.left);
            }            
        }
        sum += sumOfLeftLeaves(root.right);
        
        
        return sum;
    }
}
/*用stack的做法*/

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
    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ans = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode cur = stack.pop();
            if(cur.left != null){
                if(cur.left.left == null && cur.left.right == null){
                    ans += cur.left.val;
                }else{
                    stack.push(cur.left);
                }
            }
            if(cur.right != null){
                stack.push(cur.right);   
            }            
        }
        return ans;
        
    }
}

