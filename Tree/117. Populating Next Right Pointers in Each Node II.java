/*
就多了一个pointer而已，自己就是想不出来..
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null){
            return;
        }
        while(root != null){
            TreeLinkNode tmp = new TreeLinkNode(-1);
            TreeLinkNode curChild = tmp;
            while(root != null){
                if(root.left != null){
                    curChild.next = root.left;
                    curChild = curChild.next;
                }
                
                if(root.right != null){
                    curChild.next = root.right;
                    curChild = curChild.next;
                }
                
                root = root.next;
            }
            root = tmp.next;
        }
        
    }
}