/*类比平时的comparator，compare(int i1, int i2)
return i1 - i2;也就是将int由小到大排列。
return i2 - i1;也就是将int由大到小排列。
*/

public class Solution {
    /*
     * @param nums: A list of non negative integers
     * @return: A string
     */
    public String largestNumber(int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0){
            return "";
        }
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String str1, String str2){
                return (str2 + str1).compareTo(str1 + str2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<strs.length;i++){
            sb.append(strs[i]);
        }
        String str = sb.toString();
        int index = 0;
        if(str.charAt(0) == '0'){
            return "0";
        }
        return str;
    }
}