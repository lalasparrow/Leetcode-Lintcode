class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(prerequisites == null || prerequisites.length == 0){
            return true;
        }
        int[] inDegree = new int[numCourses];
        for(int i=0;i<prerequisites.length;i++){
            int course = prerequisites[i][0];
            int pre = prerequisites[i][1];
            inDegree[course]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<inDegree.length;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int course = q.poll();
            for(int i=0;i<prerequisites.length;i++){
                if(prerequisites[i][1] == course){
                    inDegree[prerequisites[i][0]]--;
                    if(inDegree[prerequisites[i][0]] == 0){
                        q.add(prerequisites[i][0]);
                    }
                }
            }
        }
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] > 0){
                return false;
            }
        }
        
        
        return true;
        
    }
}