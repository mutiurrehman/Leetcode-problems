class Solution {
    public int islandPerimeter(int[][] grid) {
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!vis[i][j])
                    dfs(grid,grid.length,grid[0].length,i,j,vis);
            }
        }
        return ans;
    }
    
    int ans=0;
    public void dfs(int[][] grid, int m, int n, int i, int j, boolean[][] vis){
        if(i<0|| i>=m || j<0 || j>=n|| vis[i][j] || grid[i][j] ==0){
            return;
        }
        
        vis[i][j] = true;
        int toSub =0;
        if(i+1<m){
            if(grid[i+1][j]==1)
                toSub++;
        }
        
        if(i-1>=0){
            if(grid[i-1][j]==1)
                toSub++;
        }
        
        if(j-1>=0){
            if(grid[i][j-1]==1)
                toSub++;
        }
        
        if(j+1<n){
            if(grid[i][j+1]==1)
                toSub++;
        }
        
        ans+=4-toSub;
        
        dfs(grid,m,n,i+1,j,vis);
        dfs(grid,m,n,i-1,j,vis);
        dfs(grid,m,n,i,j+1,vis);
        dfs(grid,m,n,i,j-1,vis);
    }
}