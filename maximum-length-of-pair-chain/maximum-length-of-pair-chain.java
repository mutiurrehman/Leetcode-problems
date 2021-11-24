class Solution {
    public int findLongestChain(int[][] pairs) {
        int ans=1;
        int[] dp = new int[pairs.length];
        dp[0] = 1;
        
        Arrays.sort(pairs, (a,b)-> (a[0]-b[0]));
        for(int i=1;i<pairs.length;i++){
            for(int j=0;j<i;j++){
                if(pairs[j][1]<pairs[i][0]){
                    dp[i] = Math.max(dp[i],dp[j]);
                }
            }
            
            dp[i]+=1;
            ans = Math.max(ans, dp[i]);
        }
        
        return ans;
    }
}