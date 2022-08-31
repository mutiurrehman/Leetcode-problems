class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] A) {
        
        List<List<Integer>> ans = new ArrayList<>();
    int m = A.length, n=A[0].length;
        int[][] blue = new int[m][n];
        int[][] red = new int[m][n];
       
        
        for(int i=0;i<n;i++)
        dfs(A,0,i,m,n,blue);
        
         
        for(int i=0;i<m;i++)
        dfs(A,i,0,m,n,blue);
        
        for(int i=0;i<m;i++)
        dfs(A,i,n-1,m,n,red);
        
        for(int i=0;i<n;i++)
        dfs(A,m-1,i,m,n,red);
   
        
    for(int i=0;i<m;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(blue[i][j]==1 && red[i][j]==1) {
                ans.add(Arrays.asList(i,j));
            }
        }
    }
    
    return ans;
        
    }
    
    
    public void dfs(int[][] A, int i, int j, int m, int n, int[][] vis){
        if(i<0 || i>=m || j<0 || j>=n || vis[i][j]==1)
        return;
        
        vis[i][j]=1;
        if(i>0 && A[i-1][j]>=A[i][j] && vis[i-1][j]==0)
        dfs(A,i-1,j,m,n,vis);
        
        if(i<m-1 && A[i+1][j]>=A[i][j] && vis[i+1][j]==0)
        dfs(A,i+1,j,m,n,vis);
        
        if(j>0 && A[i][j-1]>=A[i][j] && vis[i][j-1]==0)
        dfs(A,i,j-1,m,n,vis);
        
        if(j<n-1 && A[i][j+1]>=A[i][j] && vis[i][j+1]==0)
        dfs(A,i,j+1,m,n,vis);
    }
}
