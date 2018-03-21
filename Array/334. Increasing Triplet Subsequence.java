/*
 如果能找到一个数字，比当前的smallest和biggest都大，那就说明有increasing triplet
 如果找到比当前smallest小的，那么就更新smallest。
 如果找到比当前smallest大，但是比biggest的小，那么就更新biggest。
 如果找到比biggest还大的，返回true
 
 这种做法不存在biggest是在smallest的之前的情况，因为每次更新biggest都是查过smallest的
_________ ______________ ______________
_________|______________|______________
         s              b
 */


class Solution {
    public boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE;
        int biggest = Integer.MAX_VALUE;
        for(int i=0; i < nums.length; i++){
            if(nums[i] <= smallest){
                smallest = nums[i];
            }
            else if(nums[i] <= biggest){
                biggest = nums[i];
            }
            else{
                return true;
            }
        }
        return false;
    }
}
