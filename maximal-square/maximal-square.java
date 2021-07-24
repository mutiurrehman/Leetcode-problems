class Solution {
    public int maximalSquare(char[][] matrix) {
        int m=matrix.length,n=matrix[0].length;
        int[][] dp = new int[m][n];
        
        int ans = 0;
        for(int i=m-1;i>=0;i--){
            for(int j=n-1;j>=0;j--){
                if(i==m-1 && j==n-1){
                    dp[i][j]=matrix[i][j]-'0';
                    ans = Math.max(ans,dp[i][j]);
                }
                else if(i==m-1){
                    dp[i][j]=matrix[i][j]-'0';
                    ans = Math.max(ans,dp[i][j]);
                }
                else if(j==n-1){
                    dp[i][j]=matrix[i][j]-'0';
                    ans = Math.max(ans,dp[i][j]);
                }
                else{
                    if(matrix[i][j]=='0')
                        dp[i][j]=0;
                    else{
                        dp[i][j]=1+Math.min(dp[i+1][j+1],Math.min(dp[i+1][j],dp[i][j+1]));
                        ans = Math.max(ans, dp[i][j]);
                    }
                }
            }
        }
        
        return ans*ans;
    }
}