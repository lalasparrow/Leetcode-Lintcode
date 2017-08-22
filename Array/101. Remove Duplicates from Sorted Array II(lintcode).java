/**
虽然知道可以用pointer换来换去的，但是数起来真的是好麻烦啊..
所以用treemap来解了。直接计算个数，填进去
时间复杂度：如果不相同的数字的数目是m，O(mlogm)
**/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        Map<Integer, Integer> map = new TreeMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(map.get(nums[i]) <= 1){
                    map.put(nums[i], map.get(nums[i]) + 1);
                }
            }else {
                map.put(nums[i], 1);
            }
        }
        int ptr=0;
        for(Integer i: map.keySet()){
            for(int j=0;j<map.get(i);j++){
                nums[ptr++] = i;
            }
            
        }
        return ptr;
    }
}
/**
虽然有两个for循环，但是时间复杂度
时间复杂度：一个数字出现最高频率是m，不同数字的个数是n，O(n*m)
**/

public class Solution {
    /**
     * @param A: a array of integers
     * @return : return an integer
     */
    public int removeDuplicates(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return 0;
        }
        int cur = 0;
        int i,j;
        
        
        for(i=0;i<nums.length;){
            int now = nums[i];
            for(j=i; j<nums.length; j++){
                if(nums[j] != now){
                    break;
                }
                if(j-i < 2){
                    nums[cur++] = now;
                }
            }    
            i = j;
        }
        return cur;
    }
}
