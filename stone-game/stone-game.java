class Solution {
    public boolean stoneGame(int[] A) {
        dp = new int[A.length][A.length];
        for(int i=0;i<A.length;i++)
        Arrays.fill(dp[i],-1);
        
        int sum=0;
        for(int i: A){
            sum+=i;
        }
        
        int s1 =  helper(A,0,A.length-1);   
        int s2 = sum - s1;
        
        return s1>s2;
    }
    
    int[][] dp;
    
    public int helper(int[] arr , int i, int j){
        if(i > j)
        return 0;
        
        if(i==j)
        return arr[i];
        
        if(dp[i][j]!=-1)
        return dp[i][j];
        
        int s1 = arr[i] + Math.min(helper(arr,i+2,j),helper(arr,i+1,j-1));
        
        int e1 = arr[j] + Math.min(helper(arr,i,j-2),helper(arr,i+1,j-1));
        
        return dp[i][j] = Math.max(s1,e1);
    }
}