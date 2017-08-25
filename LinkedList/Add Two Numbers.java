/**
 * Definition for singly-linked list.
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
    /**
     * @param l1: the first list
     * @param l2: the second list
     * @return: the sum list of l1 and l2 
     */
    public ListNode addLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        int sum = 0, carry = 0;
        while(l1 != null || l2 != null){
            int val1 = l1 == null ? 0:l1.val;
            int val2 = l2 == null ? 0:l2.val;
            sum = val1 + val2 + carry;
            carry = sum/10;
            sum = sum%10;
           
            ListNode newNode = new ListNode(sum);
            cur.next = newNode;
            cur = cur.next;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if(carry != 0){
            cur.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}