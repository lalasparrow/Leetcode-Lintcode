public class Solution {
	private class WeightedUnionFind{
		HashMap<Integer, Integer> parent;
		HashMap<Integer, Integer> size;
		boolean hasCycle;
		int count;
	public WeightedUnionFind(int n){
		parent = new HashMap<Integer, Integer>();
		size = new HashMap<Integer, Integer>();
		hasCycle = false;
		count = n;
		for(int i = 0; i < n; i++){
			parent.put(i, i);
			size.put(i, 1);
		}
	}
	public Integer find(Integer node){
		if(!parent.containsKey(node))
			return null;
		Integer root = node;
		while(root != parent.get(root)){
			root = parent.get(root);
		}
		while(node != root){
			Integer next = parent.get(node);
			parent.put(node, root);
			node = next;
		}
		return root;
	}
	public void union(Integer nodeA, Integer nodeB){
		Integer rootA = find(nodeA);
		Integer rootB = find(nodeB);
		if(rootA == null || rootB == null)
			return;
		if(rootA.equals(rootB)){
			hasCycle = true;
			return;
		}
		int sizeA = size.get(rootA);
		int sizeB = size.get(rootB);
		if(sizeA > sizeB){
			parent.put(rootB, rootA);
			size.put(rootA, sizeA + sizeB);
		} else {
			parent.put(rootA, rootB);
			size.put(rootB, sizeA + sizeB);
		}
		count --;
	}
	public boolean hasCycle(){
		return this.hasCycle;
	}
	public boolean isTree(){
		return (!this.hasCycle) && (count == 1);
	}
}
public boolean validTree(int n, int[][] edges) {
	if(edges == null || edges.length == 0){
		if(n > 1) //不仅仅只有一棵树
			return false;
		else
			return true;
	}

	WeightedUnionFind uf = new WeightedUnionFind(n);
	for(int i = 0; i < edges.length; i++){
		int nodeA = edges[i][0];
		int nodeB = edges[i][1];
		uf.union(nodeA, nodeB);
		if(uf.hasCycle())
			return false;
	}
	return uf.isTree();
	}
}
