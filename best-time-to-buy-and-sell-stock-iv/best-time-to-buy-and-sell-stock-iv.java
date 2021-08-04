class Solution {
    public int maxProfit(int k, int[] prices) {
        if(prices.length==0 || k==0)
            return 0;
        
        int[][] dp = new int[k+1][prices.length];
        
        for(int t=1;t<=k;t++){
            for(int d=1;d<prices.length;d++){
                int max = dp[t][d-1];
                for(int pd=0;pd<d;pd++){
                    max=Math.max(max,prices[d]-prices[pd]+dp[t-1][pd]);
                }
                
                dp[t][d]=max;
            }
        }
        
        return dp[k][prices.length-1];
    }
}