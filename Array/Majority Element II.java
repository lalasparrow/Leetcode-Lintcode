public class Solution {
    /*
     * @param nums: a list of integers
     * @return: The majority number that occurs more than 1/3
     */
    public int majorityNumber(List<Integer> nums) {
        // write your code here
        int[] count = new int[2];
        int[] candidate = new int[2];
        
        for(Integer i : nums){
            if(candidate[0] == i){
                count[0]++;
            }
            else if(candidate[1] == i){
                count[1]++;
            }
            else if(count[0] == 0){
                count[0]++;
                candidate[0] = i;
            }
            else if(count[1] == 0){
                count[1]++;
                candidate[1] = i;
            }
            else{
                count[1]--;
                count[0]--;
            }
            for(int j=0;j<2;j++){
                if(count[j] > nums.size()/3){
                    return candidate[j];
                }
            }
            
        }
        count[0] = 0;
        count[1] = 0;
        for(Integer i: nums){
            if(i == candidate[0]){
                count[0]++;
            }
            if(i == candidate[1]){
                count[1]++;
            }
        }
        
        
        
        return count[0] > count[1] ? candidate[0] : candidate[1];
    }
}