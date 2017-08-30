/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        for(ListNode list : lists){
            if(list != null){
                pq.offer(list);
            }
        }
        ListNode cur = dummy;
        
        while(!pq.isEmpty()){
            ListNode tmp = pq.poll();
            if(tmp.next != null){
                pq.offer(tmp.next);
            }
            cur.next = tmp;
            cur = cur.next;
        }
             
        return dummy.next;
        
    }
}