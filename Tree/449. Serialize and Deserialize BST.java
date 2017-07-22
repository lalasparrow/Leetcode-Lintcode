/*利用前序遍历的特性来做这道题
*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    String str;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return null;
        }
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.setLength(sb.length() - 1);
        //System.out.println(sb.toString());
        return sb.toString();
    }
    private void preorder(TreeNode root, StringBuilder sb){
        if(root != null){
            sb.append(root.val + ",");
            preorder(root.left, sb);
            preorder(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0)
                return null;
        
        String[] strs = data.split(",");
        
        return helper(strs, 0, strs.length - 1);        
        
    }
    
    private TreeNode helper(String[] strs, int start, int end){
        if(start > end || strs == null){
            return null;
        }
        if(start == end) 
            return new TreeNode(Integer.valueOf(strs[start]));
        
        TreeNode root = new TreeNode(Integer.valueOf(strs[start]));
        int newEnd = start;
        
        for(int i=start+1;i<=end;i++){
            int val = Integer.valueOf(strs[i]);
            if(val > root.val){
                break;
            }
            newEnd = i;
            
        }
        TreeNode left = helper(strs, start + 1, newEnd);
        TreeNode right = helper(strs, newEnd + 1, end);
        root.left = left;
        root.right = right;
        return root;
        
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));