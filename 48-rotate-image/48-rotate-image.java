class Solution {
    public void rotate(int[][] mat) {
        
        for(int i=0;i<mat.length;i++){
            for(int j=i+1;j<mat[i].length;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
       
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
                System.out.print(mat[i][j]+ " ");
            }
            System.out.println();
        }
        
        for(int i=0;i<mat.length;i++){
            
                for(int k=0;k<mat[i].length/2;k++){
                    int temp = mat[i][k];
                    mat[i][k] = mat[i][mat[i].length-1-k];
                    mat[i][mat[i].length-1-k] = temp;
                }
            
        }
    }
}