class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum =0;
        int cnt=0;
        long maxNeg = Long.MIN_VALUE, minPos = Long.MAX_VALUE;
        boolean zero =false;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j]<0){
                    cnt++;
                    maxNeg =Math.max(maxNeg,matrix[i][j]);
                }
               
                if(matrix[i][j]>0){
                    minPos =Math.min(minPos,matrix[i][j]);
                }
                
                if(matrix[i][j]==0){
                    zero=true;
                }
                sum+=Math.abs(matrix[i][j]);
            }
        }
        
        if(cnt%2==0)
            return sum;
        
        if(zero)
            return sum;
        
        
        if(Math.abs(maxNeg)>minPos)
            return sum - 2*minPos;
        
        return sum - Math.abs(maxNeg)+maxNeg;
    }
}