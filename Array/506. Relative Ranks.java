/**
因为不仅仅是找前三名，之后的也要有次序，所以肯定是要全部sort一下。
这个方法很好..sort的是index，这样的话，之后找顺序也很好找
要注意的是，index这个array，存的是Integer，而不是int。这样array sort的时候，
才能根据(a, b) -> (nums(b), nums(a))由数字而不是index从大到小的顺序来sort
*/

class Solution {
    public String[] findRelativeRanks(int[] nums) {
        String[] res = new String[nums.length];
        Integer[] index = new Integer[nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, (a, b) -> (nums[b] - nums[a]));
        for(int i = 0; i < nums.length; i++){
            if(i == 0){
                res[index[i]] = "Gold Medal";
            }
            else if(i == 1){
                res[index[i]] = "Silver Medal"; 
            }
            else if(i == 2) {
                res[index[i]] = "Bronze Medal";
            }
            else {
                res[index[i]] = i + 1 + "";
            }
        }
        return res;
    }
}