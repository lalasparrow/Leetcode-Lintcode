/**sort之后，利用大小关系，来决定向前还是向后取数字
*/

public class Solution {
    /*
     * @param numbers: Give an array numbers of n integer
     * @return: Find all unique triplets in the array which gives the sum of zero.
     */
    public List<List<Integer>> threeSum(int[] numbers) {
        // write your code here
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(numbers);
        for(int i=0;i<numbers.length-2;i++){
            if(numbers[i] > 0){
                break;
            }
            if(i!=0&&numbers[i] == numbers[i-1]){
                continue;
            }
            int sum = 0 - numbers[i];
            int left = i+1;
            int right = numbers.length - 1;
            while(left < right){
                if(left < right && numbers[left] + numbers[right] == sum){
                    res.add(Arrays.asList(numbers[i], numbers[left], numbers[right]));
                    while(left < right && numbers[left] == numbers[left + 1]){
                        left++;
                    }
                    while(left < right && numbers[right] == numbers[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                    
                }else if(left < right && numbers[left] + numbers[right] > sum){
                    right--;
                }
                else{
                    left++;
                }
            }
        }
        return res;
    }
}