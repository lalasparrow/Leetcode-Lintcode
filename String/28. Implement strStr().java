class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack==null || haystack.length() < needle.length()){
            return -1;
        }
        if(haystack.length() == needle.length() && haystack.equals(needle)){
            return 0;
        }
        
        int len = needle.length();
        for(int i=0;i<haystack.length()-len+1;i++){
            if(haystack.substring(i, i+len).equals(needle)){
                return i;
            }
            
        }
        return -1;
        
        
    }
}