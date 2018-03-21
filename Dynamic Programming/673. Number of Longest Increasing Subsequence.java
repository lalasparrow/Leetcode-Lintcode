/*利用两个数组，一个来记录当前的longest increasing subsequence的长度，另一个来记录这么长的个数
如果遇到更大的数，有两种情况，
1. 一种是刚好是之前长度+1，就是说，刚好补了一个数，
于是至今为止的longest increasing subsequence的个数要加上之前的。

2. 另一种是大于现在的longest increasing subsequence的长度，那么就需要更新len和cnt了

最后需要记录一下max_len
*/

class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length, res = 0, max_len = 0;
        int[] len =  new int[n], cnt = new int[n];
        for(int i = 0; i<n; i++){
            len[i] = cnt[i] = 1;
            for(int j = 0; j <i ; j++){
                if(nums[i] > nums[j]){
                    if(len[i] == len[j] + 1){
                        cnt[i] += cnt[j];
                    }
                    if(len[i] < len[j] + 1){
                        len[i] = len[j] + 1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max_len == len[i]){
                res += cnt[i];
            }
            if(max_len < len[i]){
                max_len = len[i];
                res = cnt[i];
            }
        }
        return res;
    }
}