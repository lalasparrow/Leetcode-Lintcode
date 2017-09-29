/*two pointers这个技能还是没学会..*/

class Solution {
    public String minWindow(String s, String t) {
        
        int[] window = new int[256];
        int[] count = new int[256];
        
        for(int i=0; i<t.length(); i++){
            count[t.charAt(i)]++;
        }
        int size = Integer.MAX_VALUE;
        String res = "";
        int j = 0;
        for(int i=0; i<s.length(); i++){
            while(j<s.length() && !isSuff(window, count)){
                window[s.charAt(j++)]++;
            }
            if(j-i<size && isSuff(window, count)){
                res = s.substring(i, j);
                size = j-i;
            }
            window[s.charAt(i)]--;
        }
        
        return res;
    }
    private boolean isSuff(int[] window, int[] count){
        for(int i=0; i < 256; i++){
            if(window[i] < count[i]){
                return false;
            }
        }
        return true;
    }
    
}
class Solution {
    public String minWindow(String s, String t) {

        int[] count = new int[256];
        for (int i = 0; i < t.length(); i++) {
            count[t.charAt(i)]++;
        }

        int j=0;
        int curCount = 0;
        int targetCount = t.length();
        int size = Integer.MAX_VALUE;
        String res = "";
        for(int i=0; i<s.length(); i++){
            while(j < s.length() && curCount < targetCount){
                count[s.charAt(j)]--;
                if(count[s.charAt(j)] >= 0){
                    curCount++;
                }
                j++;

            }
            if(j-i < size && curCount >= targetCount){
                res = s.substring(i, j);
                size = j - i;
            }
            count[s.charAt(i)]++;
            //小于0的时候是多减的
            if(count[s.charAt(i)] > 0){
                curCount--;
            }

        }
        return res;
   }
}
