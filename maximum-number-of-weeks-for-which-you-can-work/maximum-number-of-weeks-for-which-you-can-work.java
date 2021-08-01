class Solution {
    public long numberOfWeeks(int[] m) {
        long ans =0;
    int max=-1;
        for(int i=0;i<m.length;i++){
            max=Math.max(max,m[i]);
            ans+=m[i];       
        }
        
        long rest = ans-max;
        if(max>rest)
            return 2*rest+1;
        
        
        return ans;
    }
}