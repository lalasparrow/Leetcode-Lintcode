/*是从后往前数第n个..
可以数数看一共多少个，然后减去n，然后在过一遍

也可以用两个pointer造成n的差距，然后利用n的差距来计算
*/

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
     * @return: Nth to last node of a singly linked list. 
     */
    ListNode nthToLast(ListNode head, int n) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode cur = head;
        int len = 0;
        while(cur != null){
            len++;
            cur = cur.next;
        }
        int k = len - n;
        cur = head;
        while(cur != null && k > 0){
            k--;
            cur = cur.next;
        }
        
        return cur;
    }
}
