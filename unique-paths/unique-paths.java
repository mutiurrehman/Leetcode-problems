class Solution {
    
    Integer[][] dp = new Integer[101][101];
    public int uniquePaths(int i, int j) {
     if(i==1 || j==1)
         return 1;
        if(dp[i][j]!=null)
            return dp[i][j];
        
        return dp[i][j]=uniquePaths(i,j-1)+uniquePaths(i-1,j);
    }
}