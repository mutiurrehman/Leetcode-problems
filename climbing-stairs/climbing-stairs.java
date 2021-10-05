class Solution {
    public int climbStairs(int n) {
        Arrays.fill(dp,-1);
        return helper(n);
    }
    int[] dp = new int[46];
    public int helper(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;
        
        if(n==2)
            return 2;
        
        if(dp[n]!=-1)
            return dp[n];
        
         dp[n] = helper(n-1)+helper(n-2);
        return dp[n];
    }
}