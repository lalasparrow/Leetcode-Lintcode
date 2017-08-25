/*这个方法还需要在留意一下，他没有找整个要reverse的范围，
而是从起点开始reverse m-n次，是把后面的node直接加到固定顶点（pre）的后面。

*/

/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Solution {
    /*
     * @param head: ListNode head is the head of the linked list 
     * @param m: An integer
     * @param n: An integer
     * @return: The head of the reversed ListNode
     */
     public ListNode reverseBetween(ListNode head, int m, int n) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i=0;i<m-1;i++){
            pre = pre.next;
        }
        ListNode start = pre.next;
        ListNode then = start.next;
        for(int i=0;i<n-m;i++){
            start.next = then.next;
            then.next = pre.next;
            pre.next = then;
            then = start.next;
        }
       return dummy.next;
        
    }
}