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

/*LinkedList精髓就是挪出来，以及替换值啊..*/

public class Solution {
    /*
     * @param head: The first node of linked list
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        
        if(head == null || head.next == null){
            return head;
        }
        ListNode less = new ListNode(-1);
        ListNode greater = new ListNode(-1);
        ListNode dummy1 = less;
        ListNode dummy2 = greater;
        while(head != null){
            if(head.val < x){
                less.next = head;
                less = less.next;
            }else{
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        greater.next = null;
        less.next = dummy2.next;
        return dummy1.next;
    }
}