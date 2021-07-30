class Solution {
    public int numIslands(char[][] grid) {
     int ans=0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(visited[i][j]==false && dfs(grid,i,j,visited)!=0)
                ans+=1;
            }
        }
        
        return ans;
    }
    
    public int dfs(char[][] A, int i, int j, boolean[][] visited){
        
        if(i<0 || i>=A.length || j<0 || j>=A[0].length || visited[i][j] || A[i][j]=='0')
        return 0;
        
        visited[i][j]=true;
        
        return 1 + dfs(A,i+1,j, visited) +  dfs(A,i-1,j, visited) +  dfs(A,i,j-1, visited) +  dfs(A,i,j+1, visited);
    }
}
