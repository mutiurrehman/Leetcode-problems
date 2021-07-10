class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        
        int l=0,r=-1;
        
        int count=0,odd=0;
        
        while(r<nums.length-1){
            r++;
            if(nums[r]%2==1)
                odd++;
            if(odd == k){
                int left =1;
                int right =1;
                
                while(r<nums.length-1 && nums[r+1]%2==0){
                    r++;
                    right++;               
                }
                while(l <= r && nums[l]%2==0){
                    l++;
                    left++;
                }
             count+=left*right;
                l++;
                odd--;
            }
            
        }
        
        return count;
        
    }
}