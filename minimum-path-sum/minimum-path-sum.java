class Solution {
    public int minPathSum(int[][] A) {
   int[][] dp = new int[A.length][A[0].length];
        
        int r = dp.length, c=dp[0].length;
        for(int i=r-1;i>=0;i--){
            for(int j=c-1;j>=0;j--){
                if(i==r-1 && j==c-1){
                    dp[i][j]=A[i][j];
                }
                else if(i==r-1){
                    dp[i][j]= dp[i][j+1]+A[i][j];
                }
                else if(j==c-1){
                    dp[i][j]=dp[i+1][j]+A[i][j];
                }
                else{
                    dp[i][j]=Math.min(dp[i+1][j],dp[i][j+1])+A[i][j];
                }
            }
        }
        
        return dp[0][0];
    }
}
