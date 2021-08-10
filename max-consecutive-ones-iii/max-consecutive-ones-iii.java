class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int ans =0,count=0,j=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                count++;
            
            while(count>k){
                
                if(nums[j]==0)
                    count--;
                j++;
            }
            
            ans = Math.max(ans,i-j+1);
        }
        
        return ans;
    }
}