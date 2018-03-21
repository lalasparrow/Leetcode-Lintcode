/*
注意：
里面的for循环是小于w.size() - 1的，因为最后一块砖之后，所有的都是齐的
*/
用hashmap以时间点划分，每一行砖头的终点
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size() == 0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int maxEdge = 0;
        for(List<Integer> w : wall){
            int length = 0;
            for(int i=0; i < w.size() - 1; i++){
                length += w.get(i);
                map.put(length, map.getOrDefault(length, 0) + 1);
                maxEdge = Math.max(maxEdge, map.get(length));
            }
        }
        
        return wall.size() - maxEdge;
    }
}
