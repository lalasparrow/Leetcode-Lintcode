/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        
        ListNode fast = head;
        ListNode slow = head;
    
        while(fast!=null&&fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
      
        
        if(fast != null){
            slow = slow.next;
        }
        ListNode first = head;
        ListNode second = reverse(slow);
        
        while(second != null){
            if(first.val != second.val){
                return false;
            }
            first = first.next;
            second = second.next;
        }
        
        return true;
        
    }
    
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
            
        }
        return pre;
    }
}