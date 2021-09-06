class Solution {
    public String longestPalindrome(String s) {
       int max =0,idx=0;
        for(int i=0;i<s.length();i++){
           int len1 = checkPalindrome(s,i,i);
            int len2 = checkPalindrome(s,i,i+1);
            if(max<Math.max(len1,len2)){
                idx = (len1 > len2) ? (i - len1 / 2) : (i - len2 / 2 + 1);
                max = Math.max(len1,len2);
            }
        }
        
        return s.substring(idx, idx + max);
    }
    
    
    public int checkPalindrome(String s, int i, int j){
        int count=0;
        
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
         return j - i - 2 + 1;
    }
}