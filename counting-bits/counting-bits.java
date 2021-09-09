class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        int offset = 1;
        for(int i=1;i<n+1;i++){
            if(offset*2==i){
                offset*=2;
                
            }
            dp[i] = dp[i - offset] + 1;
        }
        
        return dp;
    }
}