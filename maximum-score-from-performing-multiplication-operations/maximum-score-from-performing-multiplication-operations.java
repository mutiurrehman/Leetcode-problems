class Solution {
    
    int[][] memo ;
    public int maximumScore(int[] nums, int[] m) {
        
        memo = new int[m.length][m.length];
        for(int i=0;i<memo.length;i++)
            Arrays.fill(memo[i],-1);
        
        return helper(nums,m,0,nums.length-1,0);
    }
    
    public int helper(int[] nums, int[] multi, int s, int e,int i){
        
        if(i>=multi.length)
            return 0;
        
        if(memo[s][i]!=-1)
            return memo[s][i];
    
        int f = multi[i]*nums[s]+helper(nums,multi,s+1,e,i+1);
        int s2 = multi[i]*nums[e]+helper(nums,multi,s,e-1,i+1);
       
        
        
        return memo[s][i]=Math.max(f,s2);
    }
}