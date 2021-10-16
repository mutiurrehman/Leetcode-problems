class Solution {
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        int[][] dp = new int[n][n];
        
        int[] suff = new int[n];
        suff[n-1] = piles[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i] = suff[i+1]+piles[i];
        }
        
        return helper(piles, 0, 1, dp, suff);
    }
    
    public int helper(int[] arr, int i, int m,int[][] dp, int[] suff){
        if(i>=arr.length)
            return 0;
        
        if(2*m>arr.length-i)
            return suff[i];
        
        if(dp[i][m]!=0)
            return dp[i][m];
        
        int min = Integer.MAX_VALUE;
        
        for(int x=1;x<=2*m;x++){
        
            min = Math.min(min, helper(arr,i+x,Math.max(m,x),dp,suff));
        }
        
        dp[i][m] = suff[i] - min;
        return dp[i][m];
    }
}