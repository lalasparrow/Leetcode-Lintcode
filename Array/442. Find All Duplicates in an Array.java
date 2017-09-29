//1. 会改变原来的nums数组次序
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        
        for(int i=0; i < nums.length; i++){
            while(nums[i] != i+1 && nums[i] != nums[nums[i] - 1]){
                swap(nums, nums[i]-1, i);
            }
        }        
        for(int i=0; i < nums.length; i++){
            if(nums[i] != i + 1){
                res.add(nums[i]);
            }
        }
        return res;
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}

//2. 不改变原来的数组次序
public class Solution {
    // when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
    
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
}