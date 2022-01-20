class Solution {
    public int minEatingSpeed(int[] piles, int H) {
     
        int l=1,h=0;
        for(int i=0;i<piles.length;i++){
            h=Math.max(h,piles[i]);
        }
        
        while(l<h){
            int mid=(l+h)/2;
            int sum =0;
            for(int i=0;i<piles.length;i++){
                if(piles[i]<=mid)
                    sum++;
                else{
                    sum+=Math.ceil((double)piles[i]/mid);
                }
            }
            if(sum>H)
                l=mid+1;
            else
                h=mid;
                
            
        }
        
        return l;
    }
}