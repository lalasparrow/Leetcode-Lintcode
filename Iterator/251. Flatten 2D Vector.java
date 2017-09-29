/*
用两个iterator，一个是List<Integer>，另一个是Integer。
定义方法：
Iterator<List<Integer>> iter = arraylist.iterator(); //arraylist的type是List<List<Integer>>
Iterator<Integer> iter = arraylist.iterator(); //arraylist的type是List<Integer>

主要就是利用iterator，取代计数的count，来决定下一个iterator的数字

注意：
1. 如果当前的List<Integer>里面是空的，那么需要让这个Iterator<Integer>跳过该List<Integer>
2. 测试程序每次调用next()的时候，都会调用hasNext()函数。所以说，提前将List<Integer>空的部分跳过去，就在调用之前一次非空的时候，就跳过去，这样的话，hasNext会返回false，就不会再调用next()了。
3. []这个test case的时候，他会在躲避Corner case的if条件句之前就调用hasNext，所以说，需要将iter != null和 listItr() != null也加上。

*/

public class Vector2D implements Iterator<Integer> {
    Iterator<List<Integer>> itr = null;
    Iterator<Integer> listItr = null;
    public Vector2D(List<List<Integer>> vec2d) {
        if(vec2d == null || vec2d.size() == 0){
            return;
        }
        
        itr =  vec2d.iterator();
        listItr = itr.next().iterator();
        while(itr.hasNext() && !listItr.hasNext()){
            listItr = itr.next().iterator();
        }
    }

    @Override
    public Integer next() {
        
        int next = listItr.next();
        while(itr.hasNext() && !listItr.hasNext()){
            listItr = itr.next().iterator();                
        }
        return next;
        
    }

    @Override
    public boolean hasNext() {
       
        return itr != null && listItr != null && (itr.hasNext() || listItr.hasNext());
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */