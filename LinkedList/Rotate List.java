/*
这题题目要求如果超过list的长度的时候，需要继续rotate，
根据长度%k的得数来rotate。但是长度需要跑过一遍才知道，所以不如到了就用新的k再来一遍
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
    /**
     * @param head: the List
     * @param k: rotate to the right k places
     * @return: the list after rotation
     */
    public ListNode rotateRight(ListNode head, int k) {
        // write your code here
        if(head == null || head.next == null){
            return head;
        }
        ListNode first = head;
        ListNode second = head;
        while(first != null && k > 0){
            first = first.next;
            k--;
        }
        if(first == null){
            if(k > 0){
                return rotateRight(head, k);
            }
            
            return head;
        }
        
        // System.out.println(first.val);
        while(first.next != null){
            first = first.next;
            second = second.next;
        }
        first.next = head;
        head = second.next;
        second.next = null;
        return head;
        
        
    }
}