class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
    
        int sum =0;
        for(int i:nums)
            sum+=i;
        
        if(sum%k!=0)
            return false;
        
        if(nums.length<k)
            return false;
        
        boolean[] used = new boolean[nums.length];
        int curSum=0,subSum = sum/k,start=0;
        return helper(nums,used, start, curSum, k, subSum);
        
    }
    
    public boolean helper(int[] nums, boolean[] used, int start, int curSum, int k, int subSum){
        if(k==1)
            return true;
        
        if(curSum>subSum)
            return false;
        
        if(curSum==subSum)
            return helper(nums,used,0,0,k-1,subSum);
        
        for(int i=start;i<nums.length;i++){
            if(used[i])
                continue;
            used[i]=true;
            if(helper(nums,used,i+1,curSum+nums[i],k,subSum))
                return true;
            used[i]=false;
        }
        return false;
    }
    
}