class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        
        long left = 0, right =  (long)n*Math.min(a, b);
        int result=0;
        
        while(left<right){
            long mid = left+(right-left)/2;
            
            if(count(mid,a,b)<n){
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        
        int MOD = 1_000_000_007;
        return (int)(left%MOD);
    }
    
    
    public int count(long n, long a, long b){
        return (int)(n/a + n/b - n/lcm(a,b));
    }
    
    public long lcm(long a, long b){
        return a*b/gcd(a,b);
    }
    
    public long gcd(long a, long b){
        if(a==0)
            return b;
        
        return gcd(b%a,a);
    }
}