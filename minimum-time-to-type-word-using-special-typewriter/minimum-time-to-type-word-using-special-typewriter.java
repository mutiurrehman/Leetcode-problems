class Solution {
    public int minTimeToType(String word) {
        char[] alphas = new char[26];
        for(char i='a';i<='z';i++){
            alphas[i-'a']=i;
        }
        
        int res=0;
        int prevInd = 0;
        for(int i=0;i<word.length();i++){
            char cc = word.charAt(i);
            
            int min = Integer.MAX_VALUE;
            int cpy = prevInd;
            int ans = 0;
            while(alphas[cpy]!=cc){
                cpy++;
                cpy=cpy%26;
                ans++;
            }
            min =Math.min(min,ans);
            cpy=prevInd;
            ans=0;
            while(alphas[cpy]!=cc){
                cpy--;
                cpy = cpy % 26;
                if (cpy<0) cpy += 26;
                ans++;
            }
            prevInd = cc-'a';
             min =Math.min(min,ans);
            res+=min;
        }
        
        
        res+=word.length();
        
        return res;
    }
}