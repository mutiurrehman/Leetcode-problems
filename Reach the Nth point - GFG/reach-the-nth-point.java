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
{   public int count=0;
    public TreeMap<Integer,Integer> map=new TreeMap<>();
    int mod=1000000007;
    public int nthPoint(int n)
    {
        // Code here
        if(n==0)
        {   count++;
            return count%mod;
        }
        else if(n<0)
        {
            return count%mod;
        } 
       if(map.containsKey(n))
       {
           count=(count%mod+map.get(n)%mod)%mod;
           if(map.containsKey(n-2))
           {
               map.remove(n-2);
           }
           return count%mod;
       }
        int path1=nthPoint(n-1);
        int path2=nthPoint(n-2);
       
       if(!map.containsKey(n))
        {  
            map.put(n,count%mod);
        }
        
 return count%mod;  
 
    }
}