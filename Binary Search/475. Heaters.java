/*
目的是要找能覆盖所有房子的，heaters的最小半径。
（为什么没有给半径找heaters的题..？）
解法1：利用两个house的中间点的大小，来判断这个heater是离左边的房子更近一些，
还是离右边的房子更近一些。如果一直离右边的房子更近，比如he he he he ho的情况，
就需要把heater换成更近一点的heater来计算半径。如果离左边的房子更近的话，
那么就需要换成下一个房子。这样的话，每次计算result的时候，都是和房子左边的heater相比。

解法2：利用binary search函数，找到第一个比当前房子更大的heater，然后，
将这个heater还有他之前的heater的距离作比较，取最大值。记得判断corner case。

*/

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        
        Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int i = 0;
        int res = 0;

        // 第一种解法：
        // for(int house : houses){
        //     while(i + 1 < heaters.length && heaters[i] + heaters[i+1] <= house*2){
        //         i++;
        //     }
        //     res = Math.max(res, Math.abs(house - heaters[i]));
        // }

        // 第二种解法
        for(int house : houses){
            int index = Arrays.binarySearch(heaters, house);
            if(index < 0){
                index = -(index + 1);
            }
            int dis1 = index - 1 >=0 ? Math.abs(house - heaters[index - 1]) : Integer.MAX_VALUE;
            int dis2 = index < heaters.length ? Math.abs(house - heaters[index]) : Integer.MAX_VALUE;
            res = Math.max(res, Math.min(dis1, dis2));
        }
        
        
        return res;
    }
}