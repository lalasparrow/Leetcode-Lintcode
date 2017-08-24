/*
因为可能会去掉第一个，所以用了dummy
利用两个指针的差来找到要去除的那个的前一个listnode
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
 */ 
public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n: An integer.
     * @return: The head of linked list.
     */
    ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if(head == null || head.next == null){
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode pre = head;
        ListNode cur = dummy;
        while(pre != null && n > 0){
            pre = pre.next;
            n--;
        }
        
        while(pre!= null){
            pre = pre.next; 
            cur = cur.next;
        }
        cur.next = cur.next.next;
        
        return dummy.next;
    }
}
