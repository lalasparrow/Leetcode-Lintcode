/*
把(left,right,h)转换成(left,-h)和(right,h)

1. sort list。先根据left由小到大排序，再根据right由小到大排序。
2. 利用priority queue，根据坐标遍历整个list

存res的原理是，比较这次的高度和之前的高度有没有不同，如果有不同，就加上这个点。如果当前是(y,h)的话，记得先把(y,h) remove。这样能有高度差的变化，即地面或者比当前楼矮的高度(pq.peek())的高度，和之前更高的楼房的高度有不同(pre != cur)。这时候，把node加入res中。

相当于每个坐标维持一个priorityqueue，存放当前坐标上的高度。每次只有在是L的时候才会有高度的改变，所以只需要遍历buildings时候，height < 0的时候再offer

注意：
1. priorityqueue存放的是每栋楼的高度。
2. 地面的高度也要加上，避免空以及加上最后一个终点。pq.offer(0)。
3. 同一栋楼的起始点的h是-h，终止点的h是h。

*/

class Solution {
    public List<int[]> getSkyline(int[][] buildings){
        List<int[]> res = new ArrayList<>();
        List<int[]> heights = new ArrayList<>();
        // if(buildings == null || buildings.length == 0){
        //     return res;
        // }
        for(int[] building: buildings){
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        Collections.sort(heights, new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                if(a[0] == b[0]){
                    return a[1] - b[1];
                }
                return a[0] - b[0];
            }
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        pq.offer(0);
        int pre = 0;
        for(int[] height : heights){
            if(height[1] < 0){
                pq.add(-height[1]);
            }else{
                pq.remove(height[1]);
            }
            int cur = pq.peek();
            if(pre != cur){
                res.add(new int[]{height[0], cur});
                pre = cur;
            }
            
        }
        return res;
        
    }
}