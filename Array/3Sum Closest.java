public class Solution {
    /*
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     */
    public int threeSumClosest(int[] numbers, int target) {
        // write your code here
        int res = numbers[0] + numbers[1] + numbers[2];
        Arrays.sort(numbers);
        for(int i = 0; i < numbers.length - 2; i++){
            int left = i+1;
            int right = numbers.length - 1;
            while(left < right){
                int sum = numbers[i] + numbers[left] + numbers[right];
                if(target == sum){
                    return target;
                }
                else if(target < sum){
                    right--;
                }else{
                    left++;
                }
                if(Math.abs(sum - target) < Math.abs(res - target)){
                    res = sum;
                }
               
            }
        }
        return res;
    }
}