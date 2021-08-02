class Solution {
    public int findPeakElement(int[] nums) {
        
        if(nums.length==1)
            return 0;
        
        int l=0, h= nums.length-1;
        while(l<=h){
            int mid = (l+h)/2;
             if(mid==0){
                if(nums[0]>nums[1])
                return 0;
                else 
                return 1;
            }
            else if(mid==nums.length-1){
                if(nums[mid]>nums[mid-1])
                return mid;
                else 
                return mid-1;
            }
            else if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(nums[mid]>nums[mid-1]){
                l=mid+1;
            }
            else if(nums[mid]<nums[mid-1]){
                h=mid-1;
            }
           
        
        }
        
        return -1;
    }
}