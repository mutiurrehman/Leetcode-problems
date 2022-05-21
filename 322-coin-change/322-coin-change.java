class Solution {
    public int coinChange(int[] coins, int amount) {
        
        if(coins.length==0)
            return -1;
        if(amount==0)
            return 0;
    
        int n=coins.length;
        int[][] dp =new int[n+1][amount+1];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(j==0){
                    dp[i][j]=0;
                }
                
               if(i==0){
                    dp[i][j]=Integer.MAX_VALUE-1;
                }
            }
        }
        
    
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(coins[i-1]<=j){
                    dp[i][j]=Math.min(dp[i][j-coins[i-1]]+1,dp[i-1][j]);
                }
        else
            dp[i][j]=dp[i-1][j];
    }
}
        if(dp[coins.length][amount]==Integer.MAX_VALUE-1)
            return -1;
        return dp[coins.length][amount];
        
    }
}