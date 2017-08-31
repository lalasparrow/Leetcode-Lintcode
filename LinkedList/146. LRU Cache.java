
/*
注意：
1. 如果map里面有key，需要将value进行更新
2. 如果put的时候，map大小超过了capacity，需要remove最后tail.pre，这时候hashmap remove的是tail.pre.key。而不是tail.pre.val
*/


class LRUCache {
    Map<Integer, Node> map;
    int count;
    int capacity;
    Node head;
    Node tail;
    class Node {
        int key;
        int val;
        Node pre; 
        Node next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }


    public LRUCache(int capacity) {
        count = 0;
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
        head.pre = null;
        tail.next = null;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        remove(node);
        addHead(node);
        
        return node.val;
    }
    
    public void put(int key, int value) {
        
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            node.val = value;
            addHead(node);
        }else{
            Node node = new Node(key, value);
            if(count < capacity){
                count++;                
            }else{
                map.remove(tail.pre.key);
                remove(tail.pre);
            }
            map.put(key, node);
            addHead(node);
        }
    }
    
    private void addHead(Node node){
        node.next = head.next;
        node.pre = head;
        head.next = node;
        node.next.pre = node;
       
    }
    
    private void remove(Node node){
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    
    
    
}



/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */