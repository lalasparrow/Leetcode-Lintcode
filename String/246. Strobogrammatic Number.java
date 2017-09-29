class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0){
            return true;
        }
        
        int left = 0;
        int right = num.length() - 1;
        char[] array = num.toCharArray();
        while(left <= right){
            if(array[left] == array[right]){
                if(array[left] == '1' || array[left] == '0' || array[left] == '8'){
                    left++;
                    right--;
                }else {
                    return false;
                }                
            }else{
                if((array[left] == '6' && array[right] == '9') || (array[left] == '9' && array[right] == '6')){
                    left++;
                    right--;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
}