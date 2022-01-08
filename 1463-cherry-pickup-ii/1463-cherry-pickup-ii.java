class Solution {
    public int cherryPickup(int[][] grid) {
        
        Integer[][][] dp = new Integer[grid.length][grid[0].length][grid[0].length];
        return helper(grid, grid.length, grid[0].length, 0,0,grid[0].length-1,dp);
    }
    
    
    public int helper(int[][] grid, int m, int n, int r, int c1, int c2,Integer[][][] dp){
        if(r==m)
            return 0;
        if(dp[r][c1][c2]!=null)
            return dp[r][c1][c2];
        
        int ans=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int nc1 = c1+i, nc2 = c2+j;
                if(nc1>=0 && nc1<n && nc2>=0 && nc2<n){
                    ans = Math.max(ans, helper(grid, m, n, r+1,nc1,nc2,dp));
                }
            }
        }
        
        int cherries = c1==c2 ? grid[r][c1]:grid[r][c1]+grid[r][c2];
        return dp[r][c1][c2] = ans+cherries;
    }
}