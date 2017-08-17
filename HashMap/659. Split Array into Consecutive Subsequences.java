/**
freq存每个元素出现的次数，appendfreq存如果连着的话，而不是产生新的subsequence的时候，
的元素。也就是subsequence的下一个元素。
每次有遇到某个数字的时候，有两种可能性：
1. 和上一个subsequence连着的，也就是看appendfreq里面有没有该元素，有的话，那么可以查看subsequence
的下一个元素。
2. 产生新的subsequence，也就是新起一个序列，可以新起一个序列那么必须连着有三个，所以要看freq里面有没有i+1和i+2。
有的话，那么可以把第四个元素放到appendfreq，也就是下一个该序列可能出现的元素
**/

public class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        Map<Integer, Integer> appendfreq = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }
        
        for(int i:nums){
            if(freq.get(i) == 0){
                continue;
            }
            else if(appendfreq.getOrDefault(i, 0) > 0){
                appendfreq.put(i, appendfreq.get(i) - 1);
                appendfreq.put(i+1, appendfreq.getOrDefault(i+1, 0) + 1);
            }
            else if(freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0){
                freq.put(i+1, freq.get(i+1) - 1);
                freq.put(i+2, freq.get(i+2) - 1);
                appendfreq.put(i + 3, appendfreq.getOrDefault(i + 3, 0) + 1);
            }
            else{
                return false;
            }
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }
}