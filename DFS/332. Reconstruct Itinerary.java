/*map还是想出来了的，就是没想到还要加一个priorityqueue，
主要是因为题目要让最后排序变成smallest lexical order。
最后还要注意，helper function里面，最后的最后再将该点加入path。
*/

public class Solution {
    Map<String, PriorityQueue<String>> flights;
    LinkedList<String> path;
    public List<String> findItinerary(String[][] tickets) {
        flights = new HashMap<>();
        path = new LinkedList<>();
        for(int i = 0; i < tickets.length; i++){
            String depar = tickets[i][0];
            String dest = tickets[i][1];
            
            if(!flights.containsKey(depar)){
                flights.put(depar, new PriorityQueue<String>());
            }
            flights.get(depar).add(dest);
        }
        helper("JFK");
        return path;
    }
    private void helper(String departure){
        PriorityQueue<String> arrivals = flights.get(departure);
        while(arrivals != null && !arrivals.isEmpty()){
            helper(arrivals.poll());
        }
        path.addFirst(departure);
        
    }
    
}