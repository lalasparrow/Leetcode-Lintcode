/*别玩了listnode是个obj，所以需要comparator*/

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
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // write your code here
        
        if(lists == null || lists.size() == 0){
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.size(), new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
            
        });
        for(ListNode node : lists){
            if(node != null){
                pq.offer(node);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while(!pq.isEmpty()){
            ListNode out = pq.poll();
            if(out.next != null){
                pq.offer(out.next);
            }
            cur.next = out;
            cur = cur.next;
        }
        return dummy.next;
        
    }
}
