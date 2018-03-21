/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        
        return toBst(head, null);
    }
    private TreeNode toBst(ListNode head, ListNode tail){
        ListNode slow = head;
        ListNode fast = head;
        if(head == tail){
            return null;
        }
        
        while(fast != tail && fast.next != tail){
            fast = fast.next.next;
            slow = slow.next;
        }
        
        TreeNode newHead = new TreeNode(slow.val);
        newHead.left = toBst(head, slow);
        newHead.right = toBst(slow.next, tail);
        return newHead;
    }
    
    
}