class Solution {
    
    int[][] dp =  new int[504][504];
    public int maxCoins(int[] nums) {
        for(int i =0;i<dp.length;i++)
            Arrays.fill(dp[i],-1);
        int n = nums.length;
        int[] newArr= new int[nums.length+2];
        newArr[0]=1;
        newArr[n+1]=1;
        for(int i=1;i<=n;i++)
            newArr[i]=nums[i-1];
        
        return helper(newArr,1,newArr.length-1);
    }
    
    public int helper(int[] arr, int i, int j){
        if(i>=j)
            return 0;
        
        if(dp[i][j]!=-1)
            return dp[i][j];
        int ans = Integer.MIN_VALUE;
        for(int k =i;k<j;k++){
            int temp = helper(arr,i,k)+helper(arr,k+1,j);    
            temp+=arr[i-1]*arr[k]*arr[j];           
            ans=Math.max(ans,temp);
        }
        
        dp[i][j]=ans;
        return ans;
    }
}