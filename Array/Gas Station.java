/**计算index的时候，是根据之前sum是否是负值每次更新。
*/

public class Solution {
    /*
     * @param gas: An array of integers
     * @param cost: An array of integers
     * @return: An integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // write your code here
        if(gas == null || cost == null || gas.length != cost.length){
            return -1;
        }
        int sum = 0;
        int total = 0;
        int res = -1;
        for(int i=0; i<gas.length; i++){
            total += gas[i] - cost[i];
            sum += gas[i] - cost[i];
            if(sum < 0){
                sum = 0;
                res = i;
            }
        }
        if(total < 0){
            return -1;
        }
            
       
        return res + 1;
    }
}