class Solution {
    public int calculateMinimumHP(int[][] A) {
    int[][] dp = new int[A.length][A[0].length];
        
        for(int i=dp.length-1;i>=0;i--){
            for(int j=dp[0].length-1;j>=0;j--){
                if(i==dp.length-1 && j==dp[0].length-1){
                    dp[i][j]=Math.min(0,A[i][j]);
                }
                else if(i==dp.length-1){
                    dp[i][j]=Math.min(0, A[i][j]+dp[i][j+1]);
                }
                else if(j==dp[0].length-1){
                    dp[i][j]=Math.min(0, A[i][j]+dp[i+1][j]);
                }
                else{
                    dp[i][j]=Math.min(0, A[i][j]+Math.max(dp[i+1][j],dp[i][j+1]));
                }
            }
        }
        return Math.abs(dp[0][0])+1;
    }
}
