/*
是binary tree或者是bst，改变的其实是确定左右子树的条件。
如果是bst，可以根据值的大小来确定一棵树。
如果是binary tree就需要符号来标记leaves，每次遇到特殊符号的时候就返回，因为遇到了leaves。
deque里面元素逐个往后用，顺次能找到left和right

注意用stringbuilder，而不是string。这样的话，最后组成的string可以传回来
*/
/*
以前写的却不记得了..

用前序遍历，存储每个node到string里面

最后读出来是一起读，所以用stack或者queue都一样的，然后再根据读出来的内容来递归建立树。

要注意的是stack.addAll(Arrays.asList(data.split(spliter));要把出来的String[] 变成Collection
因为：addAll(Collection<? extends E> c)

还有读取完了queue之后要记得remove，或者在一开始就remove，这样的话，递归的时候也不会出现问题。
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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        helpSerialize(root, sb);
        return sb.toString();
    }
    private void helpSerialize(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("#,");
            //注意这里有个return！！！！
            return;
        }
        sb.append(root.val).append(",");
        helpSerialize(root.left, sb);
        helpSerialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Deque<String> dq = new LinkedList<>();
        //注意这里要把它变成Collections之后才能addAll
        dq.addAll(Arrays.asList(data.split(",")));
        return helpDeserialize(dq);        
    }
    private TreeNode helpDeserialize(Deque<String> dq){
        String str = dq.removeFirst();
        
        if(str.equals("#")){
            return null;
        }
        else {
            TreeNode newNode = new TreeNode(Integer.valueOf(str));
            newNode.left = helpDeserialize(dq);
            newNode.right = helpDeserialize(dq);
            return newNode;
        }
        
        
    }
    
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
