class Solution {
    public long mostPoints(int[][] q) {
        Arrays.fill(dp,-1);
        
        return dfs(q,0);
    }
    
    long[] dp = new long[200001];
    
    public long dfs(int[][] q, int i){
        if(i>=q.length)
            return 0;
        
        if(dp[i]!=-1)
            return dp[i];
        
        int points = q[i][0], steps = q[i][1];
        
        dp[i] = Math.max(points+dfs(q,i+steps+1), dfs(q,i+1));
        
        return dp[i];
    }
}