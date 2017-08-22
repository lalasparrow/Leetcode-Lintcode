/**
注意index不是从0开始，所以res每个都要+1
**/

public class Solution {
    /*
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<numbers.length;i++){
            if(map.containsKey(target - numbers[i])){
                res[0] = map.get(target - numbers[i]) + 1;
                res[1] = i + 1;
                return res;
            }
            if(!map.containsKey(numbers[i])){
                map.put(numbers[i], i);
            }
            
        }
        return res;
    }
}