/*一层一层的记录下来，最后弄出来的时候，一层一层的弄出来，
利用两个queue
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
class Solution {
    /**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if(root == null){
            return "";
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        String str = "";
        
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(cur == null){
                str += "#,";
            }else{
                str += cur.val + ",";
                queue.offer(cur.left);
                queue.offer(cur.right);
            }
        }
        return str;
        
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if(data.equals("")){
            return null;
        }
        String[] strs = data.split(",");
        TreeNode root = new TreeNode(Integer.valueOf(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        for(int i=1;i<strs.length;i++){
            TreeNode parent = queue.poll();
            if(!strs[i].equals("#")){
                TreeNode left = new TreeNode(Integer.valueOf(strs[i]));
                parent.left = left;
                queue.add(left);
            }
            i++;
            if(!strs[i].equals("#")){
                TreeNode right = new TreeNode(Integer.valueOf(strs[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }
}
