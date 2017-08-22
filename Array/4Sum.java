public class Solution {
    /*
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        Arrays.sort(numbers);
        return kSum(4, numbers, target, 0);
    }
    private List<List<Integer>> kSum(int k, int[] numbers, int target, int index){
        List<List<Integer>> res = new ArrayList<>();
        if(index >= numbers.length){
            return res;
        }
        if(k == 2){
            int left = index;
            int right = numbers.length - 1;
            while(left < right){
                if(left < right && numbers[left] + numbers[right] == target){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(numbers[left]);
                    tmp.add(numbers[right]);
                    res.add(tmp);
                    while(left < right && numbers[left] == numbers[left + 1]){
                        left++;
                    }
                    while(left < right && numbers[right] == numbers[right - 1]){
                        right--;
                    }
                    left++;
                    right--;
                }else if(left < right && numbers[left] + numbers[right] < target){
                    left++;
                }else {
                    right--;
                }
            }
        }else{
            for(int i=index; i<numbers.length - k + 1; i++){
                List<List<Integer>> tmp = kSum(k-1, numbers, target - numbers[i], i + 1);
                if(tmp != null){
                    for(List<Integer> list : tmp){
                        list.add(0, numbers[i]);
                    }
                    res.addAll(tmp);
                }
                while(i < numbers.length - 1 && numbers[i] == numbers[i+1]){
                    i++;
                }
                
            }
        }
        
        return res;
    }
    
}