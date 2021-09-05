class Solution {
    public int numberOfWeakCharacters(int[][] p) {
        
        Arrays.sort(p, (a,b) -> (a[0]==b[0])? a[1]-b[1] :b[0]-a[0] );
        int max =0;
        int ans =0;
        
        for(int i=0;i<p.length;i++) {
            if(p[i][1]<max)
                ans++;
            
            max=Math.max(max,p[i][1]);
        }
        
        return ans;
    }
}