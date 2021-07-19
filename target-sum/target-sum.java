class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(nums[i]==0)
                cnt++;
        }
        
        int n = nums.length;
        if(target>sum)
            return 0;
        
        if((target+sum)%2!=0)
            return 0;
        
        int range = (target + sum)/2;
        
        int[][] dp = new int[n+1][range+1];
        
        for(int i=0;i<n+1;i++){
            for(int j=0;j<range+1;j++){
                if(i==0)
                    dp[i][j]=0;
                if(j==0)
                    dp[i][j]=1;
            }
        }
        
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(nums[i-1]==0)
                    dp[i][j]=dp[i-1][j];
                else if(nums[i-1]<=j)
                    dp[i][j]=dp[i-1][j-nums[i-1]]+dp[i-1][j];
                else
                    dp[i][j]=dp[i-1][j];
            }
        }
        
        return dp[n][range]*(int)Math.pow(2,cnt);
        
    }
}