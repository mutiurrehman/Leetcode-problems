class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        HashMap<Integer, Integer>[] dp = new HashMap[nums.length];
        int n = nums.length;
        int res=0;
        for(int i=0;i<n;i++){
            dp[i] = new HashMap<>();
            for(int j=0;j<i;j++){
                long cd = (long)(nums[i])-nums[j];
                if(cd<=Integer.MIN_VALUE || cd>Integer.MAX_VALUE){
                    continue;
                }
                
                int diff = (int)cd;
                int c1 = dp[i].getOrDefault(diff,0);
                int c2 = dp[j].getOrDefault(diff,0);
                res+=c2;
                dp[i].put(diff,c1+c2+1);
            }
        }
        
        return res;
    }
}