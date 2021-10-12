class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int[] ans = new int[n];
        int sumOfM = 0;
        for(int i:rolls)
            sumOfM+=i;
        
        int s = (n+rolls.length)*mean - sumOfM;
        
        int toPut = s/n;
        if(toPut>6 || toPut <=0 )
            return new int[0];
        for(int i=0;i<n;i++){
            ans[i] = toPut;
        }
        
        s = s - toPut*n;
        int i=0;
        while(s>0 && i<n){
            int gap = 6-ans[i];
            if(s>gap){
                ans[i]+=gap;
                s=s-gap;
            }
            else{
                ans[i]+=s;
                s=0;
            }
            i++;
        }
        
        if(s>0)
            return new int[0];
        return ans;
    }
}