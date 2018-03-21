//两种方法
//1. 利用set来记录所有点的值，看有没有two sum
//2. 利用中序遍历来记录由小到大的list，然后看有没有two sum
//两个方法的时间复杂度都是O(N); 空间复杂度O(N)
//主要还是把bst转化成普通的list

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
    public boolean findTarget(TreeNode root, int k) {
        return search(new HashSet<>(), root, k);
    }
    private boolean search(Set<Integer> set, TreeNode root, int target){
        if(root == null){
            return false;
        }
        if(set.contains(target - root.val)){
            return true;
        }
        set.add(root.val);
        return search(set, root.left, target) || search(set, root.right, target);
        
    }
    
}

class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        int left = 0;
        int right = list.size() - 1;
        while(left < right){
            if(list.get(left) + list.get(right) == k){
                return true;
            }
            else if(list.get(left) + list.get(right) < k){
                left++;
            }
            else{
                right--;
            }
        }
        
        return false;
        
    }
    public void inorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
        
    }
    
}
