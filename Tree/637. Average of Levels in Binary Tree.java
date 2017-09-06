/*
先是用了最蠢的方法，把所有的node都加到对应的层里面去，最后求average。
看了看discussion觉得自己真的太蠢了..
用queue的size来确定层数，这样就能用一个queue解决了
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
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<List<Integer>> nodelist = new ArrayList<>();
        helper(nodelist, root, 0);
        List<Double> res = new ArrayList<>();
        for(List<Integer> list : nodelist){
            double sum = 0;
            for(int i=0; i < list.size(); i++){
                sum += list.get(i);
            }
            sum = sum/(double)list.size();
            res.add(sum);
        }
        
        
        return res;
    }
    private void helper(List<List<Integer>> nodelist, TreeNode root, int level){
        if(root == null){
            return;
        }
        if(nodelist.size() <= level){
            nodelist.add(new ArrayList<>());
        }
        
        nodelist.get(level).add(root.val);
        helper(nodelist, root.left, level + 1);
        helper(nodelist, root.right, level + 1);
        return;
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for(int i=0; i < size; i++){
                TreeNode cur = queue.poll();
                sum += cur.val;
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
                
            }
            res.add(sum/size);
            
        }
        
        return res;
    }
}