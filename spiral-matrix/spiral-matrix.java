class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int i=0,j=0,k=0;
        int dir = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        while(k<m*n){
            ans.add(matrix[i][j]);
            matrix[i][j] = -101;
            if(dir==0){
                j++;
                if(j==m || matrix[i][j] == -101){
                    j--;
                    i++;
                    dir = 1;
                }
            }
            else if(dir==1){
                i++;
                if(i==n|| matrix[i][j] == -101){
                    i--;
                    j--;
                    dir = 2;
                }
            }
            else if(dir ==2){
                j--;
                if(j<0|| matrix[i][j] == -101){
                    j++;
                    i--;
                    dir = 3;
                }
            }
            else{
                i--;
                if(i<0|| matrix[i][j] == -101){
                    i++;
                    j++;
                    dir=0;
                }
            }
            k++;
        }
        
        return ans;
    }
}