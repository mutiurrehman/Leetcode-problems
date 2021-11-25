class Solution {
    public int maxSubArray(int[] nums) {
     
        int ans=nums[0], maxSofar = nums[0];
        
        for(int i=1;i<nums.length;i++){
            maxSofar = Math.max(nums[i], maxSofar+nums[i]);
            ans = Math.max(ans, maxSofar);
        }
        
        return ans;
    }
}