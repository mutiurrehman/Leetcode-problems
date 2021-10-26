class Solution {
    public String stoneGameIII(int[] stoneValue) {
     
        Arrays.fill(dp, Integer.MAX_VALUE);
        int ans = helper(stoneValue,0);
        if(ans>0)
            return "Alice";
        
        if(ans==0)
            return "Tie";
        
        return "Bob";
    }
    
    int[] dp = new int[50001];
    public int helper(int[] arr, int i){
        if(i>=arr.length)
            return 0;
        if(dp[i]!=Integer.MAX_VALUE)
            return dp[i];
        int max = Integer.MIN_VALUE;
        max = Math.max(max, arr[i]- helper(arr,i+1));
        
        if(i+1<arr.length){
            max = Math.max(max, arr[i]+arr[i+1]- helper(arr,i+2));
        }
        
        if(i+2<arr.length){
            max = Math.max(max, arr[i]+arr[i+1]+arr[i+2]- helper(arr,i+3));
        }
        
        return dp[i]=max;
    }
}