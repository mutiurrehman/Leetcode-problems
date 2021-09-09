class Solution {
    public int longestSubstring(String s, int k) {
        
        int[] count = new int[26];
        
        int h, i, j, max = 0, unique, noLessThanK, idx;
        
        for(h = 1;h<=26 ;h++){
            Arrays.fill(count, 0);
            i=0;j=0;unique=0;noLessThanK=0;
            while(j<s.length()){
                idx = s.charAt(j) - 'a';
                if(unique<=h){
                    if(count[idx]==0)
                        unique++;
                    count[idx]++;
                    if(count[idx]==k){
                        noLessThanK++;
                    }
                    j++;
                }
                else{
                     idx = s.charAt(i) - 'a';
                    if(count[idx]==k)
                        noLessThanK--;
                    
                    count[idx]--;
                    if(count[idx]==0)
                        unique--;
                    i++;
                }
                if(unique==h && unique ==noLessThanK)
                    max = Math.max(max, j-i);
            }
        }
        
        return max;
    }
}