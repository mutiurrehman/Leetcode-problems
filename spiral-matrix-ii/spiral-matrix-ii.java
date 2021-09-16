class Solution {
    public int[][] generateMatrix(int A) {
       int[][] matrix = new int[A][A];
        int i=0,j=0,k=1;
        int dir = 0;
        while(k<=A*A){
            matrix[i][j] = k;
            if(dir==0){
                j++;
                if(j==A || matrix[i][j]!=0){
                    j--;
                    i++;
                    dir=1;
                }
                
            }
            else if(dir==1){
                i++;
                if(i==A||matrix[i][j]!=0){
                    i--;
                    j--;
                    dir=2;
                }
                
            }
            else if(dir == 2){
                j--;
                if(j<0 || matrix[i][j]!=0){
                    i--;
                    j++;
                    dir=3;
                }
            }
           
            else if(dir==3){
                i--;
                if(i<0|| matrix[i][j]!=0){
                    i++;
                    j++;
                    dir=0;
                }
            }
            k++;
        }
        return matrix;
    }
}