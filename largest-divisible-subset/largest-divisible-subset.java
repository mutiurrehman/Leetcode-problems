class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        int[] prev = new int[n];
        
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        int index=-1;
        int max=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]%nums[j]==0 && dp[j]+1>dp[i]){
                    dp[i] = dp[j]+1;
                    prev[i] = j;
                }
            }
            
            if(max<dp[i]){
                max = dp[i];
                index = i;
            }
        }
        
        while(index!=-1){
            ans.add(nums[index]);
            index = prev[index];
        }
        
        return ans;
    }
}