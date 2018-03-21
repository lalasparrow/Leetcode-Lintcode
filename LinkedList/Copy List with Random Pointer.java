/*利用map，key存原来的node，value存的copied node
注意：
如果head的random node还没遍历到，记得把head.random以及新的node放进map

还有一种思路，就是把每次copied node放在原来的node的后面，
比如说，原来是1->2->3，新的node用‘表示，最后变成1->1'->2->2'->3->3'
最后在过一遍，设置random，这时候，原来的random就在新的random之前
*/

/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    RandomListNode root = null;
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if(head == null){
            return null;
        }
        //key is original node, value is copied node
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode dummy = new RandomListNode(-1);
        RandomListNode cur = dummy;
        while(head != null){
            RandomListNode newNode = null;
            if(map.containsKey(head)){
                newNode = map.get(head);
            }else{
                newNode = new RandomListNode(head.label);
                map.put(head, newNode);
            }
            cur.next = newNode;
            if(head.random != null){
                if(map.containsKey(head.random)){
                    newNode.random = map.get(head.random);
                }else{
                    newNode.random = new RandomListNode(head.random.label);
                    map.put(head.random, newNode.random);
                }
            }
            cur = cur.next;
            head = head.next;
        }
        
        
        return dummy.next;
    }
}

Space： O(1)

public RandomListNode copyRandomList(RandomListNode head) {
    if (head == null)
        return null;
    RandomListNode cur = head;
    while (cur != null) {
        RandomListNode newNode = new RandomListNode(cur.label);
        newNode.next = cur.next;
        cur.next = newNode;
        cur = cur.next.next;
    }
    cur = head;
    while (cur != null) {
        if (cur.random != null){
            //新建出来的node的random也要指向新建出来的random
            cur.next.random = cur.random.next;
        }

        cur = cur.next.next;
    }
    cur = head;
    RandomListNode newHead = head.next;
    while (cur != null) {
        RandomListNode newNode = cur.next;
        cur.next = newNode.next;
        cur = cur.next;
        if (cur != null){
            newNode.next = cur.next;
        }
    }
    return newHead;
}
