class Solution {
    public int minStartValue(int[] nums) {
        int pre=0,ans =0;
        boolean flag = true;
        for(int i=0;i<nums.length;i++){
            pre+=nums[i];
            if(nums[i]<0)
                flag = false;
            if(pre<0)
                ans = Math.max(ans,Math.abs(pre));
        }
    
        if(flag)
            return 1;
        
        return ans+1;
    }
}