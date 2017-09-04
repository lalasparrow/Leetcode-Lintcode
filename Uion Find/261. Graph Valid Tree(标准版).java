/**
UnionFind里面，用一个hashmap存node-parent。

find的时候，如果find到的最终的parent不是map里面存的parent，那么需要把node和node以前的所有的node的parent都更新为最终的parent

union的时候，需要把size小的连在size大的上面。这就需要把size小的root改成size大的root，同时改一下size大的size，因为连上了另外一坨。

因为这里面是找有没有一颗树，所以一是找有没有圈，确定是个树的形态；二要找最后的边的个数是不是n-1，防止两棵树的产生。


*/

class Solution {
    public boolean validTree(int n, int[][] edges) {
        unionFind uf = new unionFind(n);
        for(int i=0; i < edges.length; i++){
            uf.union(edges[i][0], edges[i][1]);
            if(uf.hasCycle()){
                return false;
            }
        }
        return uf.isTree();
    }
    
    class unionFind{
        int n;
        Map<Integer, Integer> parent;
        Map<Integer, Integer> size;
        boolean hasCycle;
        int count;
        public unionFind(int n){
            this.n = n;
            parent = new HashMap<>();
            size = new HashMap<>();
            count = n;
            for(int i=0; i < n; i++){
                parent.put(i, i);
                size.put(i, 1);
            }
        }
        private boolean hasCycle(){
            return this.hasCycle;
        }
        
        private boolean isTree(){
            return (!this.hasCycle) && (count == 1);
        }
        private void union(int num1, int num2){
            Integer root1 = find(num1);
            Integer root2 = find(num2);
            
            if(root1 == null || root2 == null){
                return;
            }
            if(root1 == root2){
                hasCycle = true;
                return;
            }
            int size1 = size.get(root1);
            int size2 = size.get(root2);
            
            if(size1 > size2){
                parent.put(root2, root1);
                size.put(root1, size1 + size2);
                
            }else{
                parent.put(root1, root2);
                size.put(root2, size1+size2);
            }
            count--;   
        }
        
        private Integer find(Integer num){
            if(!parent.containsKey(num)){
                return null;
            }
            Integer root = num;
            while(root != parent.get(root)){
                root = parent.get(root);
            }
            while(num != root){
                Integer next = parent.get(num);
                parent.put(num, root);
                num = next;
            }
            return root;
            
        }
        
    }
}