// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.nthPoint(n);
            System.out.println(ans);            
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    Integer[] dp = new Integer[10001];
    int mod = 1000000007;
    public int nthPoint(int n)
    {
        // Code here
        if(n==0 || n==1 || n==2)
            return n;
        
        if(dp[n]!=null)
        return dp[n]%mod;
        
        dp[n] = (nthPoint(n-1)%mod+nthPoint(n-2)%mod)%mod;
        return dp[n]%mod;
    }
}