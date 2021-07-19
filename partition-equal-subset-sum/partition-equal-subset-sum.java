class Solution {
    public boolean canPartition(int[] nums) {
        int ts = 0;
        
        for(int i=0;i<nums.length;i++)
            ts+=nums[i];
        
        if(ts%2!=0)
            return false;
        
        ts = ts/2;
        
        boolean[][] dp = new boolean[nums.length+1][ts+1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(i==0)
                    dp[i][j]=false;
                if(j==0)
                    dp[i][j]=true;
            }
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
             
                if(nums[i-1]<=j){
                    dp[i][j]= dp[i-1][j-nums[i-1]] || dp[i-1][j];
                    
                }
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        
        return dp[nums.length][ts];
    }
}