/*要抓住超过一半的特性，就算这个数把剩下的一半数都抵了，
也还剩下一个
*/
class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for(int i=1;i<nums.length;i++){
            if(res == nums[i]){
                count++;
            }
            else if(count == 0){
                res = nums[i];
                count++;
            }
            else {
                count--;
            }
        }
        return res;
    }
}