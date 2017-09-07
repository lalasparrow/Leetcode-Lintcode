/*
1. 把每个task发生的次数存放到countTask里面
2. 把task发生的次数，由大到小放进queue里面，这样保证每个task都放进去了queue里面一次
3. 利用curTime这个变量来记录当前的时间，已经排过的task放进coolDown这个map里面， 
里面map里面存储的是（curTime - 发生次数）这一对

注意：
map里面查看有没有curTime-n-1这个key。可以把idle避开，如果都没有的话，就直接curTime++了。
因为此时queue是空，map也没有curTime-n-1这个key，所以curTime可以直接++


*/



class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> countTask = new HashMap<>();
        for(char task : tasks){
            countTask.put(task, countTask.getOrDefault(task, 0) + 1);
        }
        
        Queue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        
        for(char count : countTask.keySet()){
            queue.offer(countTask.get(count));
        }
        
        int curTime = 0;
        Map<Integer, Integer> coolDown = new HashMap<>();
        while(!queue.isEmpty() || !coolDown.isEmpty()){
            if(coolDown.containsKey(curTime - n - 1)){
                queue.offer(coolDown.remove(curTime - n - 1));
            }
            
            if(!queue.isEmpty()){
                int cur = queue.poll() - 1;
                if(cur != 0){
                    coolDown.put(curTime, cur);
                }
               
            }            
            curTime++;
        }
        
        return curTime;
    }
}