/*注意push的时候<=都要把min push进去，比如push 1 1 2 1这种情况，
明明最小值一直是1，如果只在<的时候push min，那么在1的时候，min就变成了2

*/

public class MinStack {
    
    private int min;
    private Stack<Integer> stack;
    public MinStack() {
        // do initialize if necessary
        min = Integer.MAX_VALUE;
        stack = new Stack<>();
    }

    public void push(int number) {
        // write your code here        
        if(number <= min){
            stack.push(min);
            min = number;
        }
        stack.push(number);   
    }

    public int pop() {
        // write your code here
        int n = stack.pop();
        if(n == min){
            min = stack.pop();
        }
        return n;
        
    }

    public int min() {
        // write your code here
        return this.min;
        
    }
}

