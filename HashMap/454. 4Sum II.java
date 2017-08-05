/*会解k sum之后，这个就比较简单了。
就是把问题拆成几部分，看有没有和为0的部分
*/

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length; j++){
                map.put(A[i] + B[j], map.getOrDefault(A[i]+B[j], 0) + 1);
            }
        }
        int res = 0;
        for(int i=0;i<C.length;i++){
            for(int j=0;j<D.length;j++){
                if(map.containsKey(- C[i] - D[j])){
                    res += map.get(-C[i] - D[j]);
                }
            }
        }
        
        return res;
    }
}