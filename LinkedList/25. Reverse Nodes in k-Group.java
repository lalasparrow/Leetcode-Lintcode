/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/*Linked list的题每次都要数清楚啊..*/
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2){
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy;
        ListNode prev = dummy;
        ListNode tmp = dummy;
        while(true){
            int count = k;
            while(count > 0 && tail != null){
                count--;
                tail = tail.next;
            }
            if(tail == null){
                break;
            }
            head = prev.next;
            while(prev.next != tail){
                tmp = prev.next;
                prev.next = tmp.next;
                tmp.next = tail.next;
                tail.next = tmp;
            }
            tail = head;
            prev = head;
            
        }
        
        return dummy.next;
        
    }
    
    
}