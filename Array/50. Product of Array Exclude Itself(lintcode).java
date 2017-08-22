/**
除法主要是要注意0，不要除以0

后来才发现不让用除法，那么只能前面的乘起来再乘以后面的乘起来
**/

public class Solution {
    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        List<Long> res = new ArrayList<>();
        long sum = 1;
        int countZero = 0;
        for(Integer i : nums){
            if(i==0){
                countZero++;
            }else{
                sum *= i;
            }
        }
        
        for(int i=0;i<nums.size();i++){
            if(countZero == 0){
                res.add(sum/nums.get(i));
            }else if(countZero == 1){
                if(nums.get(i) != 0){
                    res.add((long)0);
                }else{
                    res.add(sum);
                }
            }else{
                res.add((long)0);
            }
        }
        return res;
    }
}