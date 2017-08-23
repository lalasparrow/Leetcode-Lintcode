/**
这里面要注意的是：
加入res之前要sort，sort的时候，不能更改两个index的值
要在加入sort之后，加入res的时候，更改index

*/


public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number 
     *          and the index of the last number
     */
    class Pair{
        int sum;
        int index;
        public Pair(int sum, int index){
            this.sum = sum;
            this.index = index;
        }
    }
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int[] res = new int[2];
        if(nums == null || nums.length == 0){
            return res;
        }
        if(nums.length == 1){
            return new int[]{0,0};
        }
        Pair[] sums = new Pair[nums.length+1];
        sums[0] = new Pair(0, 0);
        for(int i=1;i<sums.length;i++){
            sums[i] = new Pair(sums[i-1].sum + nums[i-1], i);
        }
        
        Arrays.sort(sums, new Comparator<Pair>(){
            public int compare(Pair a, Pair b){
                return a.sum - b.sum;
            }
        });
        
        int diff = Integer.MAX_VALUE;
        for(int i=1; i<sums.length; i++){
            if(diff > sums[i].sum - sums[i-1].sum){
                diff = sums[i].sum - sums[i-1].sum;
                int[] tmp = new int[]{sums[i].index, sums[i-1].index};
                Arrays.sort(tmp);
                res[0] = tmp[0];
                res[1] = tmp[1]-1;
            }
        }
        return res;
    }
}
