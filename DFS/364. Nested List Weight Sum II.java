/*和I不同，这次weight的次序相反。
如果是I的话，iteratively调用，每次level+1就行了。
这次的话，要想到其实就是带着把前面的都加一遍，
所以有了weigth和unweight两个变量，
unweight是当前的总和，最后走完这一层之后，都加到weight上面，
由于unweight并没有把前面的都清空，所以，
之后weight会继续叠加原来unweight的值。这样就相当于乘以了层数。
*/

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *     // Constructor initializes an empty nested list.
 *     public NestedInteger();
 *
 *     // Constructor initializes a single integer.
 *     public NestedInteger(int value);
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // Set this NestedInteger to hold a single integer.
 *     public void setInteger(int value);
 *
 *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
 *     public void add(NestedInteger ni);
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class Solution {
    int sum = 0;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        int weight = 0, unweight = 0;
        while(!nestedList.isEmpty()){
            List<NestedInteger> nextList = new ArrayList<>();
            for(NestedInteger i: nestedList){
                if(i.isInteger()){
                    unweight += i.getInteger();
                }else{
                    nextList.addAll(i.getList());
                }
            }
            weight += unweight;
            nestedList = nextList;
        }   
        return weight;
    }
}