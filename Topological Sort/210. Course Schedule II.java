/*
注意：
1. Queue的定义：
        Queue<Integer> q = new LinkedList<>();
2. 每个map都要加上list。是为了避免没有prerequisite的情况，这样queue poll出来能直接加到array res
*/

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < numCourses; i ++) {
            List<Integer> list = new ArrayList<>();
            map.put(i, list);
        }
        
        for(int i=0;i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            inDegree[course]++;
            map.get(pre).add(course);
        }
        int[] res = new int[numCourses];
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        int index = 0;
        while(!q.isEmpty()){
            int pre = q.poll();
            res[index++] = pre;
            List<Integer> course = map.get(pre);
            for(Integer i : course){
                inDegree[i]--;
                if(inDegree[i] == 0){
                    q.add(i);
                }
            }
            
        }
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] > 0){
                return new int[0];
            }
        }
        
        return res;
        
    }
}