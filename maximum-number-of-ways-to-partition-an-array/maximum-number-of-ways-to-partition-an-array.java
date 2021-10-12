class Solution {
    public int waysToPartition(int[] nums, int k) {
        long sum =0;
        for(int i:nums)
            sum+=i;
        
        int n = nums.length;
        HashMap<Long, Integer> leftCount = new HashMap<>();
        HashMap<Long, Integer> rightCount = new HashMap<>();
        
        long left = 0;
        long right = 0;
        for(int i=0;i<n-1;i++){
            left+=nums[i];
            right = (sum - left);
            rightCount.put(left - right, rightCount.getOrDefault(left-right,0)+1);
        }
        
        //System.out.println(rightCount);
        long ans = rightCount.getOrDefault((long)0,0);
        left = 0; right =0;
        for(int i=0;i<n;i++){
            left+=nums[i];
             right = (sum - left);
            long d = k - nums[i];
            ans = Math.max(ans,rightCount.getOrDefault(-d,0)+leftCount.getOrDefault(d,0) );
             rightCount.put(left - right, rightCount.getOrDefault(left-right,0)-1);
            leftCount.put(left - right, leftCount.getOrDefault(left-right,0)+1);
           
        }
    
        return (int)ans;
    }
}