/*
主要是有一个start来确定起点。

*/

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<>();
        if(nums == null){
            return res;
        }
        int n = nums.length;
        
        int start = lower;
         for(int i = 0; i < n; i++) {
             if(start < nums[i]) {
                addRange(res, start, nums[i]-1);   
             }
             
             if(nums[i] == upper){
                 return res;
             }
             
             start = nums[i] + 1;
        }
        
        if(start <= upper){
            addRange(res, start, upper);
        }
        
        return res;
    }
    private void addRange(List<String> list, int lo, int hi) {
        if(lo > hi) return;
        else if(lo == hi) list.add(String.valueOf(lo));
        else list.add(lo + "->" + hi);
    }
}