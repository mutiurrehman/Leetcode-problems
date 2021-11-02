class Solution {
    int empty,res;
    public int uniquePathsIII(int[][] grid) {
        empty=1;
        res=0;
        int si=0,sj=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==0)
                    empty++;
                if(grid[i][j] ==1){
                    si=i;
                    sj=j;
                }
            }
        }
        
        dfs(grid,si,sj);
        
        return res;
    }
    
    public void dfs(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[i].length||grid[i][j]<0){
            return;
        }
        
        if(grid[i][j]==2){
           if(empty==0) 
               res++;
            return;
        }
        
        grid[i][j] = -2;
        empty--;
        dfs(grid,i-1,j);
        dfs(grid,i,j-1);
        dfs(grid,i+1,j);
        dfs(grid,i,j+1);
        grid[i][j] = 0;
        empty++;
    }
}