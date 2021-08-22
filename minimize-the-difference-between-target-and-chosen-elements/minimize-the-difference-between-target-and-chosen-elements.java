class Solution {
    public int minimizeTheDifference(int[][] mat, int target) {
       dp = new int[mat.length][5001];
        for(int i=0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        
        return helper(mat,0,0,target);
    }
    
    int[][] dp;
    
    public int helper(int[][] mat, int row, int val, int target){
        if(row>=mat.length)
            return Math.abs(target-val);
       
       if(dp[row][val]!=-1)
          return dp[row][val];
        
        int ans=Integer.MAX_VALUE;
        for(int j=0;j<mat[0].length;j++){ 
            ans = Math.min(ans, helper(mat,row+1,val + mat[row][j], target));
        }
        
        
        dp[row][val] = ans;
        return ans;
    }
}