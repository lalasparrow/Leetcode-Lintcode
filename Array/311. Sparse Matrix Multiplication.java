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