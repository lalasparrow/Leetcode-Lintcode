/*我看别人好像都是用的sort来做的，pq也一样，
只不过就是[0,0]这种test case要把0都除掉，
换言之，就是最后答案如果前面都是0的部分要去掉，
如果是00这种就只能留下一个0*/

class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        PriorityQueue<String> pq = new PriorityQueue<String>(nums.length, new Comparator<String>(){
            public int compare(String s1, String s2){
                return (s2 + s1).compareTo(s1 + s2);
            }
        }); 
        String res = "";
        for(int i=0; i < nums.length; i++){
            
            pq.offer(nums[i] + "");
        }
        while(!pq.isEmpty()){
            res += pq.poll();
        }
        int ptr = 0;
        while(ptr < res.length() && res.charAt(ptr) == '0'){
            ptr++;
        }
        
        
        return ptr != res.length() ? res.substring(ptr) : "0";
    }
}