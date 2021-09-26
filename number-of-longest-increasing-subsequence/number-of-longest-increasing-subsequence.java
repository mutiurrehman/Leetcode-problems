class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];//\U0001f469‍\U0001f9b1
        int[] cnt = new int[n];
        int res =0, max_length=0;
        for(int i=0;i<n;i++){
            dp[i] = 1;
            cnt[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(dp[i]==dp[j]+1){
                        cnt[i]+=cnt[j];
                    }
                    
                    if(dp[i]<dp[j]+1){
                        dp[i] = dp[j]+1;
                        cnt[i] = cnt[j];
                    }
                }
            }
            if(max_length==dp[i])
                res+=cnt[i];
            
            if(max_length<dp[i]){
                max_length=dp[i];
                res=cnt[i];
            }
            
        }
        
        return res;
    }
}