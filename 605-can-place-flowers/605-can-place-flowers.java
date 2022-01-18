class Solution {
    public boolean canPlaceFlowers(int[] f, int n) {
        if(f.length==1 && f[0] == 0 && n<=1)
            return true;
        else if(f.length==1&&f[0] == 0 && n>1){
            return false;
        }
        
        for(int i=0;i<f.length;i++){
            if(f[i]==1){
                continue;
            }
            else if(i>0 && i<f.length-1 &&f[i-1]!=1 && f[i+1]!=1){
                f[i] = 1;
                n--;
            }
            else if(i==0 && i<f.length-1 && f[i]!=1 && f[i+1]!=1){
                f[i] = 1;
                n--;
            }
            else if(i == f.length-1 && i>0 && f[i-1]!=1 && f[i]!=1){
                f[i] = 1;
                n--;
            }
        }
        
        return n<=0;
    }
}