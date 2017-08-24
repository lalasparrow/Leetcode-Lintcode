/*需要注意第二个while之后first是不是null*/

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
    /**
     * @param ListNode head is the head of the linked list
     * @return: ListNode head of linked list
     */
    public static ListNode deleteDuplicates(ListNode head) { 
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode first = head.next;
        ListNode second = head;
        while(first != null){
            while(first != null && first.val == second.val){
                first = first.next;
            }
            second.next = first;
            first = first == null ? null : first.next;
            second = second.next;
        }
        return head;
    }  
}