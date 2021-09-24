class Solution {
    public int partitionDisjoint(int[] nums) {
        
        boolean check = true;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]!=nums[i+1]){
                check = false;
                break;
            }
        }
        
        if(check){
            return 1;
        }
        int[] prefixMax = new int[nums.length];
        prefixMax[0] = nums[0];
        
        for(int i=1;i<nums.length;i++){
            prefixMax[i] = Math.max(prefixMax[i-1],nums[i]);
        }
        
        int[] suffixMin = new int[nums.length];
        suffixMin[nums.length-1] = nums[nums.length-1];
        
        for(int i=nums.length-2;i>=0;i--){
            suffixMin[i] = Math.min(suffixMin[i+1], nums[i]);
        }
        
        int ans=0;
        for(int i=0;i<nums.length;i++){
            
            if(i==0){
                if(nums[i]<suffixMin[i+1]){
                    ans = i+1;
                    break;
                }
            }
            
            else if(i==nums.length-1){
                if(nums[i]>=prefixMax[i]){
                    ans = i+1;
                    break;
                }
            }
            else if(prefixMax[i-1]<=suffixMin[i+1]){
                ans = i+1;
                break;
            }
        }
        
        return ans;
    }
}