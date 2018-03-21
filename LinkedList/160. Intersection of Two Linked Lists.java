/*
a1-a2-c1-c2-c3-b1-b2-b3-c1
b1-b2-b3-c1-c2-c3-a1-a2-c1
两个访问完相同的长度之后就会访问intersection了

*/


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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;
        
        
        while(a != b){
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
            
        }
        return a;
        
    }
}