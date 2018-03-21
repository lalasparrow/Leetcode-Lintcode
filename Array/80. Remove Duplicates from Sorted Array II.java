/*每个数字只能出现一次*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=1) return nums.length;
        int count=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[count-1]){
                nums[count++]=nums[i];
            }
        }
        return count;
    }
}
/*每个数字可以出现两次*/
class Solution {
    public int removeDuplicates(int[] nums) {
        //left用于指没有重复的位置
        int left = 0;
        for(int i=0; i < nums.length; i++){
            //没有重复的话，就放到left里面
            if(left < 2 || nums[i] != nums[left - 2]){
                nums[left++] = nums[i];
            }
        }
        return left;
    }
}
