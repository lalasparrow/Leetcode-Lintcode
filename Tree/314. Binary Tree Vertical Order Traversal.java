/*
用一个map来存最后res中的index - 值list。用一个queue来递归整棵树。
主要是要想到node.left的index是当前index-1；node.right的index是当前的index+1
**/

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
    class Node{
        TreeNode node;
        int index;
        public Node(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
        
    }
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(root, 0));
        int min = 0;
        int max = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            min = Math.min(min, node.index);
            max = Math.max(max, node.index);
            if(!map.containsKey(node.index)){
                map.put(node.index, new ArrayList<>());
            }
            map.get(node.index).add(node.node.val);
            
            if(node.node.left != null){
                queue.offer(new Node(node.node.left, node.index - 1));
                
            }
            if(node.node.right != null){
                queue.offer(new Node(node.node.right, node.index + 1));
            }
        }
        for(int i=min; i <= max; i++){
            if(map.containsKey(i)){
                res.add(map.get(i));
            }
        }
        return res;        
    }
    
}