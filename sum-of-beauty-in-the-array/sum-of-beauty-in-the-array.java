class Solution {
    public int sumOfBeauties(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        
        prefixMax[0] = nums[0];
        for(int i=1;i<n;i++){
            prefixMax[i] = Math.max(nums[i],prefixMax[i-1]);
        }
        
        int[] suffixMin = new int[n];
        suffixMin[n-1] = nums[n-1];
        for(int i = n-2;i>=0;i--){
            suffixMin[i] = Math.min(nums[i], suffixMin[i+1]);
        }
        
        int beauty = 0;
        for(int i=1;i<=n-2;i++){
            if(prefixMax[i-1]<nums[i] && suffixMin[i+1]>nums[i])
                beauty+=2;
            else if(nums[i-1]<nums[i] && nums[i+1]>nums[i])
                beauty++;
        }
        
        return beauty;
    }
}