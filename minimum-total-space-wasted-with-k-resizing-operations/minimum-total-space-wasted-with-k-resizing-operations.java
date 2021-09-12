class Solution {
    
    int[][] dp = new int[200][200];
    int INF = (int) (200 * 1e6);
    public int minSpaceWastedKResizing(int[] nums, int k) {
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
            
        }
        
        return helper(nums,0,k);
    }
    
    public int helper(int[] nums, int i, int k){
        if(i==nums.length)
            return 0;
        
        if(k<0)
            return INF;
        
        if(dp[i][k]!=-1)
            return dp[i][k];
        int ans = INF, maxNum = nums[i], sum = 0;
        
        for(int j=i;j<nums.length;j++){
            sum+=nums[j];
            maxNum = Math.max(maxNum, nums[j]);
            
            int wasted = maxNum*(j-i+1) - sum;
            ans = Math.min(ans, helper(nums,j+1,k-1)+wasted);
        }
        
        return dp[i][k] = ans;
    }
}