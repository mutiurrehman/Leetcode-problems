class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        
        int max = Integer.MIN_VALUE;
        for(int i: nums){
            max = Math.max(max, i);
        }
        
        int low = 1, high = max;
        int ans =0;
        while(low<=high){
            int mid = low+(high-low)/2;
            int c = check(nums,mid);
            if(c<=threshold){
                ans = mid;
                high= mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return ans;
    }
    
    public int check(int[] nums, int mid){
        int sum=0;
        for(int i:nums){
            if(i%mid==0)
                sum+=i/mid;
            else{
                sum+=i/mid+1;
            }
        }
        
        return sum;
    }
}