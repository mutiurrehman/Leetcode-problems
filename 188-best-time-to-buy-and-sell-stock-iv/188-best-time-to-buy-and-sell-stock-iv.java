class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0 || k==0)
            return 0;
        
        int[][] dp = new int[k+1][prices.length];
        
        for(int t=1;t<=k;t++){
            int max=Integer.MIN_VALUE;
            for(int d=1;d<prices.length;d++){
                max=Math.max(dp[t-1][d-1]-prices[d-1],max);
                dp[t][d]=Math.max(dp[t][d-1],max+prices[d]);
                
            }
        }
        
        return dp[k][prices.length-1];
    }
}