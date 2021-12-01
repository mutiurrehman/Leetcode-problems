class Solution {
    
    int[] dp;
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return solve(nums, n-1);
    }
    
    public int solve(int[] arr, int i){
        if(i<0)
        return 0;
        
        if(dp[i]!=-1)
            return dp[i];
        
        int max = Integer.MIN_VALUE;
        
        max = Math.max(solve(arr,i-2)+arr[i], solve(arr,i-1));
        
        return dp[i] = max;
    }
}