class Solution {
    public int trap(int[] A) {
        
      
          int n = A.length;
        
        if(n==0)
            return 0;
        

        int[] pre = new int[n];
        int[] suf = new int[n];
        
        pre[0]=A[0];
        for(int i=1;i<n;i++)
        pre[i]= Math.max(pre[i-1],A[i]);
        
        suf[n-1]=A[n-1];
        for(int i=n-2;i>=0;i--)
        suf[i]=Math.max(suf[i+1],A[i]);
        
        int ans = 0;
        for(int i=0;i<n;i++)
        ans+=(Math.min(pre[i],suf[i])-A[i]);
        
        return ans;
        
        
    }
}