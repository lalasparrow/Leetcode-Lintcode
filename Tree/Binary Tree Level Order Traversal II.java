/*其实比较直白的方法是计算一遍高度，然后利用高度-level的的值，来加进list
但是就是要过一遍树比较麻烦

这种加list的第一个试试看，但是要注意，如果同是第二层的list，
第二层第一个node加了新的list在res里面，在遇到第二层第二个node的时候，就不能再加新的list，
需要找到刚刚加进去的list。
所以这时候解决方法就是，把所有的new list都加进去，最后利用size() - level - 1的关系，
加node的值。

另一种方法，利用queue，存取每层的值，存到list里面，每次把list加到res的第一个。
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
     * @param root: A tree
     * @return: buttom-up level order a list of lists of integer
     */
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode root, List<List<Integer>> res, int level){
        if(root == null){
            return;
        }
        if(level >= res.size()){
            List<Integer> list = new ArrayList<>();
            res.add(0,list);
        }
        helper(root.left, res, level + 1);
        helper(root.right, res, level + 1);
        
        List<Integer> list = res.get(res.size() - level - 1);
        list.add(root.val);
    }
}