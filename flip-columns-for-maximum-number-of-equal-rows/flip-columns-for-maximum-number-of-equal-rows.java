class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int ans =0;
        
        for(int i=0;i<matrix.length;i++){
            int cnt =0;
            int[] flip = new int[matrix[i].length];
            for(int j=0;j<flip.length;j++){
                flip[j]=1-matrix[i][j];
            }
            for(int j=i;j<matrix.length;j++){
                if(Arrays.equals(matrix[j], matrix[i]) || Arrays.equals(matrix[j], flip)) cnt++;
    
            }
            ans = Math.max(cnt,ans);
        }
        
        return ans;
    }
}