class Solution {
    public int reverse(int x) {
        int y =0;
        while(x!=0){
            int rem = x%10;
            
            int yy =y*10+rem;
            
              if ((yy - rem)/10 != y) 
                  return 0;
        else y = yy;
            
            
            
            x=x/10;
        }
        return y;
    }
}