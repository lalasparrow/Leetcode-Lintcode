/*
1. sort - O(NlogN)
//counting是基于最大的h-index是citations.length这个特性的
2. counting - O(N)
*/


//1. sort
/*看官方答案里面的图(柱状图)，
|_
| |_
| | |
| | |
| | |_ _
|_|_|_|_|_____
可以知道，需要找的点是y=x的那个点。所以一端从y=citations[citations.length - 1]开始，另一端从0开始，来找这个点

等号的选择取决于题目的要求
*/

class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int index = 0;
        for(int i=citations.length-1; i >= 0; i--){
            if(citations[i] > index){
                index++;
            }
        }
        return index;
    }
}

//2. counting其实也可以是bucket sort，只不过bucket因为特性最大是n+1而已
/*其实思路都是一样的，都是找y=x那个点，只不过这次用一个bucket
*/
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n+1];
        for(int i=0; i < n; i++){
            if(citations[i] >= n){
                count[n]++;
            }else{
                count[citations[i]]++;
            }
        }
        int biggestCount = 0;
        for(int i=n; i>=0; i--){
            biggestCount+=count[i];
            if(biggestCount >= i){
               return i; 
            }
        }
        
        return 0;
    }
}