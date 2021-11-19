class Solution {
    public int hammingDistance(int x, int y) {
        int ans = x^y;
        int res=0;
        
        while(ans!=0){
            if((ans&1)==1){
                res++;
            }
            ans >>=1;
        }
        
        return res;
    }
}