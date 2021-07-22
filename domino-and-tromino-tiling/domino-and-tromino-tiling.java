class Solution {
  public int numTilings(int N) {
       
      int a=0,b=1,c=1,c2,mod=1000000007;
      
      
     while(--N>0){
         c2 = (2*c%1000000007+a)%mod;
         a=b;
         b=c;
         c=c2;
        
     }
      
      return c;
    }
}