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