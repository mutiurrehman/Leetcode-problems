class Solution {
    public int[] singleNumber(int[] nums) {
        int xy = 0;
        for(int i:nums){
            xy^=i;
        }
        
        int diff = xy&-xy;
        int[] ans = new int[2];
        for(int i:nums){
            if((diff&i)==0){
                ans[0]^=i;
            }
            else{
                ans[1]^=i;
            }
        }
        
        return ans;
    }
}