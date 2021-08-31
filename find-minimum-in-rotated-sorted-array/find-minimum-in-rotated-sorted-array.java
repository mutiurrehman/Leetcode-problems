class Solution {
    public int findMin(int[] nums) {
        if(nums[0]<=nums[nums.length-1])
            return nums[0];
        int l=0,h=nums.length-1,n=nums.length;
        
        int pivot =-1;
        while(l<=h){
            if(nums[l]<=nums[h])
                return nums[l];
            int mid = (l+h)/2;
         
            int next = (mid+1)%n;
            int prev = (mid+n-1)%n;
            if(nums[mid]<=nums[prev] && nums[mid]<=nums[next]){
                pivot = mid;
                break;
            }
            
            if(nums[l]<=nums[mid]){
                l=mid+1;
            }
            else if(nums[mid]<=nums[h])
                h=mid-1;
        }
        
        return nums[pivot];
    }
}