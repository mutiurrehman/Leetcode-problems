class Solution {
    
    int[][] dirs ={{0,1},{1,0},{0,-1},{-1,0}};
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        
        int ans =1;
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                ans = Math.max(ans, dfs(matrix,i,j,dp));
            }
        }
        
        return ans;
    }
    
    public int dfs(int[][] matrix, int i, int j, int[][] dp){
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int max = 1;
        for(int[] dir: dirs){
            int x = dir[0]+i, y = dir[1]+j;
            if(x<0 || x>=matrix.length || y<0 || y>=matrix[0].length||matrix[x][y]<= matrix[i][j])
                continue;
            int len = 1+dfs(matrix, x,y,dp);
            max = Math.max(max, len);
        }
        
        return dp[i][j] = max;
    }
}