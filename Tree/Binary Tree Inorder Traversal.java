/*练习一下stack的inorder traversal写法
注意：
1. cur node是在while循环外面定义的变量。
2. while的条件是cur != null或者！！！！stack不为空
3. cur = cur.left; cur = cur.right;这两个老是忘掉

preorder的话只要把add那行改一下就行了

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
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
        
            cur = stack.pop();
            res.add(cur.val);
            cur = cur.right;
            
        }
        
        return res;

    }
}