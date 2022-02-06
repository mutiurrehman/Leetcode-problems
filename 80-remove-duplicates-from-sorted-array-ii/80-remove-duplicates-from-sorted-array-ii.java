class Solution {
    public int removeDuplicates(int[] nums) {
        
        int res=0,cnt=2;
        
        for(int val:nums){
            if(res<cnt || val > nums[res-cnt]){
                nums[res] = val;
                res++;
            }
        }
        
        return res;
    }
}