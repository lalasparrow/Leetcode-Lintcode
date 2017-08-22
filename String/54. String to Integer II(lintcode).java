/**
需要注意的点比较多：
1、符号
2、MAX_VALUE, MIN_VALUE（所以需要用double来代表result）
3、空白
4、null或者length == 0
5、小数
**/

public class Solution {
    /*
     * @param str: A string
     * @return: An integer
     */
    public int atoi(String str) {
        // write your code here
        if(str == null || str.length() == 0){
            return 0;
        }   
        str = str.trim();
        int flag = 1;
        if(str.charAt(0) == '+'){
            flag = 1;
            str = str.substring(1, str.length());
        }
        else if(str.charAt(0) == '-'){
            flag = -1;
            str = str.substring(1, str.length());
        }
        double result = 0;
        int i = 0;
        
        while(i < str.length() && str.charAt(i) <= '9' && str.charAt(i) >= '0'){
            result = result*10 + Character.getNumericValue(str.charAt(i));
            i++;
        }
        //System.out.println(result);
        result = result*flag;
        result = result >= Integer.MAX_VALUE ? Integer.MAX_VALUE : result;
        result = result <= Integer.MIN_VALUE ? Integer.MIN_VALUE : result;
        return (int)result;
    }
}