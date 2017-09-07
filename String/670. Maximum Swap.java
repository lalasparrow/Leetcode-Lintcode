/*
道理就是从头开始找，比当前的数字大的最大的数字，然后跟它交换。
比较巧妙的地方就是记录下这个数字产生的最靠后的index，这样交换的时候，得到的数字能更大。
比如10202，和最后一个2交换产生的数字肯定比第一个2交换产生的数字大，也就是把当前数字交换后在的位置尽量靠后放

*/

class Solution {
    public int maximumSwap(int num) {
        char[] digits = Integer.toString(num).toCharArray();
        
        int[] bucket = new int[10];
        for(int i=0; i < digits.length; i++){
            bucket[digits[i] - '0'] = i;
        }
        for(int i=0; i < digits.length; i++){
            for(int k=9; k > digits[i] - '0'; k--){
                if(bucket[k] > i){
                    char tmp = digits[i];
                    digits[i] = digits[bucket[k]];
                    digits[bucket[k]] = tmp;
                    return Integer.valueOf(new String(digits));
                        
                }
                
            }
        }
        return num;
        
    }
}