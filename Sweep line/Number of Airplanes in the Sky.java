






/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 */

/*这种方法时间复杂度完全是由区间的大小决定，而不是区间个数决定的，如果区间够大，那么复杂度就会很高*/

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        
        if(airplanes == null || airplanes.size()==0){
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        
        for (Interval interval: airplanes) {  
            for(int i=interval.start; i<interval.end;i++){
                if(map.containsKey(i)){
                    map.put(i, map.get(i)+1); 
                }else{
                    map.put(i, 1);
                }
                max = Math.max(max, map.get(i));
            }
            
        }
        
        return max;
    }
}