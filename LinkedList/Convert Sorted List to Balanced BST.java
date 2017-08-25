/*
这样做，而不是利用root递归的好处是：时间复杂度是O(n)。
一直想不明白为什么直接利用长度，而不是截长度，然后递归，
建立BST。如果截长度递归是O(N*logN)。
而这样只需要遍历一遍list就行了。
可以这样想，BST的inorder traversal得到的list是从小到大排列的。
那么现在只需要进行reverse-inorder就行了。也就是利用长度进行build BST。
因为是balanced，所以长度要除以2。反正左边和右边都是升序排列。

**/

/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
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
    /**
     * @param head: The first node of linked list.
     * @return: a tree node
     */
     ListNode cur = null;
     
    public TreeNode sortedListToBST(ListNode head) {  
        // write your code here
        int length = count(head);
        cur = head;
        return helper(length);
    }
    private int count(ListNode head){
        int res = 0;
        while(head != null){
            res++;
            head = head.next;
        }
        return res;
    }
    //length是子树的点的个数
    private TreeNode helper(int length){
        if(length <= 0){
            return null;
        }
        
        TreeNode left = helper(length/2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        //-1是为了把root刨除
        TreeNode right = helper(length - length/2 - 1);
        root.left = left;
        root.right = right;
        return root;
    }
    
}

