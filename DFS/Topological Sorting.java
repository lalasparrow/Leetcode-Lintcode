/*这题只要求一个路径，想多了*/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) { label = x; neighbors = new ArrayList<DirectedGraphNode>(); }
 * };
 */
public class Solution {
    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */    
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> res = new ArrayList<>();
        if(graph == null || graph.size() == 0){
            return res;
        }
        Map<DirectedGraphNode, Integer> income = new HashMap<>();
        for(DirectedGraphNode node : graph){
            for(DirectedGraphNode neig : node.neighbors){
                if(income.containsKey(neig)){
                    income.put(neig, income.get(neig) + 1);
                }else{
                    income.put(neig, 1);
                }
            }
        }
        Queue<DirectedGraphNode> q = new LinkedList<>();
        for(DirectedGraphNode node : graph){
            if(!income.containsKey(node)){
                q.offer(node);
                res.add(node);
            }
        }
        while(!q.isEmpty()){
            DirectedGraphNode node = q.poll();
            for(DirectedGraphNode neig : node.neighbors){
                int incomingedge = income.get(neig) - 1;
                if(incomingedge == 0){
                    res.add(neig);
                    q.offer(neig);
                }
                income.put(neig, incomingedge);
            }
            
        }
        
        return res;
    }
    
    
}