/*失手把steps[1]也置为0了
O(n^2)会超时..
所以还是greedy着吧。
*/

/*dp*/
public class Solution {
    /*
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        int[] steps = new int[A.length];
        Arrays.fill(steps, Integer.MAX_VALUE);
        
        steps[0] = 0;
        for(int i=1; i<A.length; i++){
            for(int j = 0; j < i; j++){
                if(steps[j] != Integer.MAX_VALUE && A[j] + j >= i){
                    steps[i] = Math.min(steps[i], steps[j] + 1);
                }
                
            }
        }
        
        return steps[A.length-1];
    }
}

/*greedy alg
要注意循环的条件，i<A.length - 1   &&   i<=max，
2 3 1 1 4这种情况，在最后4 == max的时候不必再加了，因为已经到达终点了
不在max里面说明jump不过去。

计算一次jump能到达的最大的范围，并记录，在这次jump中到达的可能点能到达的最大的范围，
如果超过了这个max范围的话，就count++
*/
public class Solution {
    /*
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] A) {
        // write your code here
        if(A == null || A.length == 0){
            return -1;
        }
        int max = 0;
        int count = 0;
        int nextMax= 0;

        for(int i=0; i<A.length-1 && i<= max; i++){
            nextMax = Math.max(nextMax, A[i] + i);
            if(i == max){
                max = nextMax;
                count++;
            }
        }
        return max >= A.length - 1 ? count : -1;
    }
}