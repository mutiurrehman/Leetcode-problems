class Solution {
    public int countOrders(int n) {
        long[] dp = new long[502];
        dp[1] = 1L;
        dp[2] = 6L;
        
        for(int i=3;i<=n;i++){
            int sc = (i-1)*2+1;
            long tot = sc*(sc+1)/2;
            dp[i] = (dp[i-1]*tot)%1000000007;
        }
        
        return (int)dp[n];
    }
}