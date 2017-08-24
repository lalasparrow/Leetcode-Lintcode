/*
moore voting.
对于有几个最多出现k次的元素，应该是最多有k-1个，因此每次包
一. candidate的长度小于k-1，并且candidate里面还没该元素
    那么，可以多加candidate的数目，并不用管其他的东西。
二. candidate长度大于k-1 或者 candidate里面已经有了该元素
    分两种情况：
1. candidate里面没有该元素（也就是说，其实candidate的大小是大于等于k-1）
            此时又有两种情况：
            a. 有count数目为零的元素
                那么把零元素给清除，candidate空出了一个位置，然后把这个元素加进去
            b. 没有count数目为零的元素
                此时，因为没有和当前element相同的candidate，那么就把所有的candidate的count都-1

2. candidate里面已经有了该元素
            把这个元素加进去
*/

public class Solution {
    /**
     * @param nums: A list of integers
     * @param k: As described
     * @return: The majority number
     */
    public int majorityNumber(List<Integer> nums, int k) {
        List<Integer> counts = new ArrayList<>();
        List<Integer> candidates = new ArrayList<>();
        
        if(nums == null || nums.size() == 0){
            return -1;
        }
        for(int i = 0; i < nums.size(); i++){
            int num = nums.get(i);
            if(candidates.size() < k - 1 &&!candidates.contains(num)){
                candidates.add(num);
                counts.add(1);
            }else{
                int index = candidates.indexOf(num);
                if(index != -1){
                    counts.set(index, counts.get(index) + 1);
                }else{
                    int zero = counts.indexOf(0);
                    if(zero != -1){
                        candidates.remove(zero);
                        counts.remove(zero);
                        candidates.add(num);
                        counts.add(1);
                    }else{
                        for(int a = 0 ; a < counts.size(); a++){
                            counts.set(a, counts.get(a) - 1);
                        }
                    }
                }
            }
            
        }
        Collections.fill(counts, 0);
        for(int i = 0; i < candidates.size(); i++){
            for(int num : nums){
                if(num == candidates.get(i))
                    counts.set(i, counts.get(i) + 1);
            }
            if(counts.get(i) > nums.size()/k)
                return candidates.get(i);
            
        }
        return -1;
    }
}