class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        
        int res=0;
        for(int i=0;i<grid1.length;i++){
            for(int j=0;j<grid1[i].length;j++){
                if(grid2[i][j]==1)
                {
                    res+=dfs(grid1,grid2,i,j);
                }
            }
        }
        return res;
        
    }
    
    public int dfs(int[][] grid1, int[][] grid2, int i, int j){
        if(i>=grid2.length||j>=grid2[0].length||i<0||j<0|| grid2[i][j]==0)
            return 1;
        
        int res=1;
        grid2[i][j]=0;
        res &= dfs(grid1,grid2,i-1,j);
        res &= dfs(grid1,grid2,i,j-1);
        res &= dfs(grid1,grid2,i+1,j);
        res &= dfs(grid1,grid2,i,j+1);
        
        return res & grid1[i][j];
        
        
    }
}