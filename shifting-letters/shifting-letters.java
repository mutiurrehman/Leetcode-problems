class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        int[] suff = new int[n];
      
        for(int i=0;i<n;i++){
            if(shifts[i]>=26){
                shifts[i] = shifts[i]%26;
            }
        }
        
        suff[n-1] = shifts[n-1];
        for(int i=n-2;i>=0;i--){
            suff[i] = suff[i+1]+shifts[i];
        }
        
        char[] ans = s.toCharArray();
        for(int i=0;i<n;i++){
            suff[i] = suff[i]%26;
            if((ans[i]+suff[i])>'z'){
                int distFromZ = 'z' - ans[i];
                suff[i] -= distFromZ;
                char t = 'a';
                t+=suff[i]-1;
                ans[i]= t;
            }
            else{
                ans[i] +=suff[i];
            }
        }
        
        return String.valueOf(ans); 
    }
}