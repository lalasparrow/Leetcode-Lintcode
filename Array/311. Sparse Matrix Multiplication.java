求稀疏矩阵的和
1. 最简单的broce force，跳过为0的数字
class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int rowA = A.length;
        int colArowB = A[0].length;
        int colB = B[0].length;
        int[][] C = new int[rowA][colB];
        
        for(int i=0; i < rowA; i++){
            for(int j=0; j < colArowB; j++){
                if(A[i][j] != 0){
                    for(int k=0; k < colB; k++){
                        if(B[j][k] != 0)    C[i][k] += A[i][j] * B[j][k]; 
                    }   
                }
            }
        }
        return C;
    }
    
}

2. 存A矩阵的每行的hashmap，行(i) - (对应的每个hashmap: 列(j) - A[i][j])
public class Solution {
    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length, g = A[0].length, n = B[0].length;
        Map<Integer, HashMap<Integer, Integer>> mapA = new HashMap<>();
        int[][] c = new int[m][n];
        // Map<Integer, HashMap<Integer, Integer>> mapB = new HashMap<>();
        // add matrix A
        for (int i = 0; i < m; ++i) {
            HashMap<Integer, Integer> tmp = new HashMap<>();
            for (int j = 0; j < g; ++j) {
                if (A[i][j] != 0) tmp.put(j, A[i][j]);
            }
            mapA.put(i, tmp);
        }
        // Multiplication
        for (int i = 0; i < m; ++i) {
            HashMap<Integer, Integer> tmp = mapA.get(i);
            for (Integer k : tmp.keySet()) {
                for (int j = 0; j < n; ++j) c[i][j] += tmp.get(k) * B[k][j];
            }
        }
        return c;
    }
}


3. 利用node这个class，把所有非零的元素都存进去
public class Solution{
    class Node {
        int x,y;
        Node(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    public int[][] multiply(int[][] A, int[][] B) {
        int[][] result = new int[A.length][B[0].length];
        List<Node> listA = new ArrayList<>();
        List<Node> listB = new ArrayList<>();
        for (int i=0;i<A.length;i++) {
            for (int j=0; j<A[0].length; j++) {
                if (A[i][j]!=0) listA.add(new Node(i,j));
            }
        }
        for (int i=0;i<B.length;i++) {
            for (int j=0;j<B[0].length;j++) {
                if (B[i][j]!=0) listB.add(new Node(i,j));
            }
        }

        for (Node nodeA : listA) {
            for (Node nodeB: listB) {
                if (nodeA.y==nodeB.x) {
                    result[nodeA.x][nodeB.y] += A[nodeA.x][nodeA.y] * B[nodeB.x][nodeB.y];
                }
            }
        }

        return result;
    }
}
