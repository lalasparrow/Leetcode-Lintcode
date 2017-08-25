/*
fast一次走两步，slow一次走一步
看最后能不能遇上，如果能遇上说明有圈；如果fast走到最后还没有遇上，说明没有圈

还可以用set做，看当前的node是否存在在set里面，存在的话，说明第二次遇到他，那么就是有圈了
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
     * @return: True if it has a cycle, or false
     */
    public boolean hasCycle(ListNode head) {  
        // write your code here
        if(head == null){
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                return true;
            }
            
        }
        return false;
    }


    // public boolean hasCycle(ListNode head) {
    //     Set<ListNode> nodesSeen = new HashSet<>();
    //     while (head != null) {
    //         if (nodesSeen.contains(head)) {
    //             return true;
    //         } else {
    //             nodesSeen.add(head);
    //         }
    //         head = head.next;
    //     }
    //     return false;
    // }
}


