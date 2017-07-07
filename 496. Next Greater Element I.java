/*因为要找右侧第一个和当前值比更大的数字，
所以要选stack来存。并且用hashmap来存储每一对。
这样可以达到O(N)。
*/

public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[findNums.length];
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            while(!stack.isEmpty()&&stack.peek()<num){
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        for(int i=0;i<findNums.length;i++){
            if(map.containsKey(findNums[i])){
                res[i] = map.get(findNums[i]);
            }else{
                res[i] = -1;
            }

        }
        return res;
    }
}
