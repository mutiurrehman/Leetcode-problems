class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        
        int[][] grid = new int[n][n];
        
        for(int i=0;i<n;i++){
            Arrays.fill(grid[i],n);
        }
        
        for(int i=0;i<mines.length;i++){
            grid[mines[i][0]][mines[i][1]] = 0;
        }
        
        int ans =0;
        for(int i=0;i<n;i++){
            
            for(int j=0, l=0;j<n;j++){
                grid[i][j] = Math.min(grid[i][j], l = grid[i][j]==0 ? 0 : l+1);
            }
            
            for(int k=n-1,r=0;k>=0;k--){
                grid[i][k] = Math.min(grid[i][k], r = grid[i][k]==0 ? 0 : r+1);
            }
            
            for(int j=0,d=0;j<n;j++){
                grid[j][i] = Math.min(grid[j][i], d = grid[j][i] == 0? 0 : d+1);
            }
            
            for(int k = n-1,u=0;k>=0;k--){
                grid[k][i] = Math.min(grid[k][i], u = grid[k][i]==0 ? 0 : u+1);
            }
           
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                ans = Math.max(ans, grid[i][j]);
            }
        }
        
        return ans;
    }
}