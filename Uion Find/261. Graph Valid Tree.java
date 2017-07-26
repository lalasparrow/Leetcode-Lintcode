/*最开始想的时候，觉得应该给排个序，然后再一个一个找，
但是，这样每次都要找一遍，并不是很节约时间，所以用union-find。
因为有union的部分，所以找起来很快。
这次用一个数组就能解决，不需要size hashmap了。
*/

public class Solution {
    public boolean validTree(int n, int[][] edges) {
        int[] nums = new int[n];
        Arrays.fill(nums, -1);
        for(int i=0;i<edges.length;i++){
            int x = find(nums, edges[i][0]);
            int y = find(nums, edges[i][1]);
            if(x == y){
                return false;
            }
            nums[x] = y;
        }
        return edges.length == n-1;
    }
    private int find(int[] nums, int x){
        if(nums[x] == -1)   return x;
        return find(nums, nums[x]);
    }
    
}