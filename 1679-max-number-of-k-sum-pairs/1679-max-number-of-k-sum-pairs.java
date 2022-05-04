class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i=0, j=nums.length-1,ans=0;
        while(i<j){
            int sum = nums[i]+nums[j];
            if(sum==k){
                ans++;
                i++;
                j--;
            }
            else if(sum<k)
                i++;
            else
                j--;
        }
        
        
        return ans;
    }
}