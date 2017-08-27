/*还是利用level和size()的关系来做*/
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
     * @return: A list of lists of integer include the zigzag level order traversal of its nodes' values.
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        
        if(root == null){
            return res;
        }
        helper(root, res, 0);
        return res;
    }
   
    private void helper(TreeNode root, List<List<Integer>> res, int level){
        if(root == null){
            return;
        }
        
        if(level >= res.size()){
            List<Integer> list = new ArrayList<>();
            res.add(list);
        }
        List<Integer> list = res.get(level);
        
        if(level%2 == 0){
            list.add(root.val);
        }else{
            list.add(0, root.val);
        }
        
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
        
    }
    
    
}