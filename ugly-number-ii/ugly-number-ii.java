class Solution {
    public int nthUglyNumber(int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        int i=0,j=0,k=0;
        
        for(int l=0;l<n;l++){
            int mA = ans.get(i)*2;
            int mB = ans.get(j)*3;
            int mC = ans.get(k)*5;
            
            int min = Math.min(mA, Math.min(mB,mC));
            ans.add(min);
            if(min==mA)
                i++;
            
            if(min == mB)
                j++;
            
            if(min==mC)
                k++;
        }
        
       //ans.remove(0);
        
        return ans.get(n-1);
    }
}