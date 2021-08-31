class Solution {
    public int movesToMakeZigzag(int[] nums) {
     
        int n = nums.length, left,right;
        int[] res = new int[2];
        
        for(int i=0;i<n;i++){
            left = i>0?nums[i-1]:1001;
            right = i<n-1?nums[i+1]:1001;
            
            res[i%2]+=Math.max(0, nums[i]-Math.min(left,right)+1);
        }
        
        return Math.min(res[1],res[0]);
    }
}