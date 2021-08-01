class Solution {
      public long minimumPerimeter(long x) {
         long i=1;
        for(;x>0;i++){
            x-=3*i*4; // i*4+2*i*4
            x-=(((2*i)*(2*i-1))/2-(i*(i+1))/2)*8; // summation using (n*(n+1))/2
        }
        return (i-1)*8;
    }
}