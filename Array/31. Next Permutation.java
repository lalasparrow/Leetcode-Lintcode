/*
   /\
  /  \  /\
 /    \/  \ 
/          \

以[1,5,8,2,4,10,9,7] -> [1,5,8,2,7,4,9,10]为例，
找到第一个图中倒数第一个凹下去的地方j，然后让这个数字nums[j]和从后往前数，
第一个比他大的数字nums[i]交换，然后再reverse j后面的数字。
原因是，既然从j开始都是降序排列，那么就想找到第一个比他大的数字，
替代这一位。然而之后都是降序排列，所以需要整个降序的数字最小，因此reverse，
这是后reverse和sort是一样的，但是因为要求用O(n)解答，所以用的reverse。
时间复杂度: O(n)
空间复杂度: O(1)
*/

/*
这题写了好几遍..怎么还是这样啊..
错在了：
1、第一个while要把相同的数字过掉
2、要确保j是>=0的，这样在进入swap的流程，否则直接reverse
*/


public class Solution {
    public void nextPermutation(int[] nums) {
    	if(nums == null || nums.length < 2){
    		return;
    	}
    	int j = nums.length - 2;
    	while(j>=0&&nums[j+1] <= nums[j]){
    		j--;
    	}
    	if(j>=0){
    		int i = nums.length - 1;
    		while(i>=0 && nums[i]<=nums[j]){
    			i--;
    		}
    		swap(nums, i, j);
    	}
    	reverse(nums, j+1);

    }
    private void swap(int[] nums, int i, int j){
    	int tmp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = tmp;
    }

    private void reverse(int[] nums, int start){
    	int end = nums.length - 1;
    	while(start < end){
    		swap(nums, start, end);
    		start++;
    		end--;
    	}
    }
}