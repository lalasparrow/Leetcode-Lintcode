public boolean binarySearch(int key, int[] nums){
    int left = 0;
    int right = size - 1;
      
    while(left <= right) {
        int middle =  left + right) / 2;
        if(nums[middle] == key) {
            return true;
        }
        if(nums[middle] < key) {
            left = middle + 1;
        }
        if(nums[middle] > key) {
            right = middle - 1;
        }
    }
    return false;
}
