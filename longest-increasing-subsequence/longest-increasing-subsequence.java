class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        
        dp[0] = 1;
        int ans = dp[0];
        for(int i=1;i<n;i++){
            for(int j =0;j<i;j++){
                if(nums[i]>nums[j])
                dp[i] = Math.max(dp[i], dp[j]);
            }
            dp[i]+=1;
            
            ans = Math.max(ans,dp[i]);
        }
        return ans;
    }
}