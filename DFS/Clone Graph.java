/*
注意：
map.get(cur.label).neighbors.add(map.get(neig.label));
cur.label是原来图的node
*/

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if(node == null){
            return null;
        }
        Map<Integer, UndirectedGraphNode> map = new HashMap<>();
        UndirectedGraphNode root = new UndirectedGraphNode(node.label);
        map.put(node.label, root);

        Stack<UndirectedGraphNode> stack = new Stack<>();
        stack.push(node);
        while(!stack.isEmpty()){
            UndirectedGraphNode cur = stack.pop();
            for(UndirectedGraphNode neig: cur.neighbors){
                if(!map.containsKey(neig.label)){
                    UndirectedGraphNode newNode = new UndirectedGraphNode(neig.label);
                    map.put(neig.label, newNode);
                    stack.push(neig);
                }
                map.get(cur.label).neighbors.add(map.get(neig.label));
            }
        }

        
        return root;
    }
}