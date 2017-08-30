/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(intervals == null){
            return intervals;
        }
        List<Interval> res = new ArrayList<>();
        Collections.sort(intervals, new Comparator<Interval>(){
            public int compare(Interval i1, Interval i2){
                if(i1.start == i2.start){
                    return i1.end - i2.end;
                }else{
                    return i1.start - i2.start;
                }
            }
        });
        int i = 0;
        
        while(i < intervals.size() && intervals.get(i).end < newInterval.start){
            res.add(intervals.get(i));
            i++;
        }
        
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end){
            newInterval = new Interval(Math.min(intervals.get(i).start, newInterval.start), Math.max(intervals.get(i).end, newInterval.end));
            i++;
        }
        res.add(newInterval);
        while(i < intervals.size()){
            res.add(intervals.get(i));
            i++;
        }
        
        
        return res;
        
        
        
    }
}