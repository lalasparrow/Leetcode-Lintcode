/*因为不仅仅第一个可能是A[0]，所以要在每个元素的地方都来找一遍试试看。
当在第i个元素的时候，顺次查找.
这里有个要注意的地方，就是++的时候不是加加的元素的index，而是当前的size。
最后将size进行取最大的操作，得到每个index的地方最大的元素。
*/
public class Solution {
    public int arrayNesting(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int maxsize = 0;
        for(int i=0;i<nums.length;i++){
            int size = 0;
            for(int k=i;nums[k]>=0;size++){
                int ak = nums[k];
                nums[k] = -1;
                k = ak;
            }
            maxsize = Math.max(maxsize, size);

        }
        return maxsize;

    }
}
