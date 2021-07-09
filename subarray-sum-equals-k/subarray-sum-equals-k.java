class Solution {
    public int subarraySum(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int preSum=0,ans=0;
        for(int i=0;i<nums.length;i++){
            preSum+=nums[i];
            if(map.containsKey(preSum-k)){
                ans+=map.get(preSum-k);
            }
            if(preSum==k)
                ans++;
            if(map.containsKey(preSum))
                map.put(preSum,map.get(preSum)+1);
            else
                map.put(preSum,1);
        }
        
        return ans;
        
    }
}