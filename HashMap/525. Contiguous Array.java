/*
1. 用hashmap，时间复杂度：O(N)
觉得这个zero - one可以用数学理解：
zero - one = k
(zero + m) - (one + n) = k
通过上面这两个式子就能够得到m - n = 0，也就是这一段增加的zero和one是相等的数量

也可以这样理解，每次遇到zero的时候+1，每次遇到one的时候-1，最后看两个的差值，差值相同也就是说明中间的zero和one的数量是一样的。

注意：
1. map最开始要put(0, -1)，因为有可能是从头开始的。

*/


class Solution {
    public int findMaxLength(int[] nums) {
        int zero = 0;
        int one = 0;
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(0, -1);
        for(int i=0; i < nums.length; i++){
            if(nums[i] == 0){
                zero++;
            }else{
                one++;
            }
            if(map.containsKey(zero - one)){
                len = Math.max(len, i - map.get(zero - one));
                
            }else{
                map.put(zero - one, i);
            }
        }
        
        return len;
    }
}

//同样的hashmap的解法，道理一样
class Solution {
    public int findMaxLength(int[] nums) {
        int len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        for(int i=0; i < nums.length; i++){
            count += nums[i] == 0 ? 1: -1;
            
            if(map.containsKey(count)){
                len = Math.max(len, i - map.get(count));
            }else{
                map.put(count, i);
            }
        }
        return len;
    }
}

