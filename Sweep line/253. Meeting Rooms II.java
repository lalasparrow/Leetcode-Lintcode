/**
找到可以merge的区间就merge，不能merge的区间就放进去，相当于加了一个new room
时间复杂度：O(NlogN)
**/

/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length <= 1){
            return intervals.length;
        }
        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.end - b.end);
        pq.offer(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            Interval in = pq.poll();
            if(in.end <= intervals[i].start){
                in.end = intervals[i].end;
            }else{
                pq.offer(intervals[i]);
            }
            pq.offer(in);
        }
        return pq.size();
        
    }
}
/**
还有一种做法，其实就是数每个end前面有几个start
*/
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals.length <= 1){
            return intervals.length;
        }
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0; i<intervals.length; i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int count = 0;
        int endPtr = 0;
        for(int i=0;i<intervals.length; i++){
            if(start[i] < end[endPtr]){
                count++;
            }else {
                endPtr++;
            }
        }
        return count;
        
    }
}

