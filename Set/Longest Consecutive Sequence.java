/*O(N)的方法用set还是要看一下的*/

public class Solution {
    /*
     * @param num: A list of integers
     * @return: An integer
     */
    public int longestConsecutive(int[] num) {
        // write your code here
        if(num.length <=1){
            return num.length;
        }
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<num.length;i++){
            set.add(num[i]);
        }
        for(int i=0; i<num.length;i++){
            int down = num[i] - 1;
            while(set.contains(down)){
                set.remove(down);
                down--;
            }
            int up = num[i] + 1;
            while(set.contains(up)){
                set.remove(up);
                up++;
            }
            max = Math.max(max, up - down - 1);
        }
        
        
        return max;
    }
}