class Solution {
    public String longestPalindrome(String s) {
        
        boolean[][] dp = new boolean[s.length()][s.length()];
        
        int ans =1,start=0,end=0;
        for(int g=0;g<s.length();g++){
            for(int i=0,j=g;j<s.length();i++,j++){
                if(g==0){
                    dp[i][j]=true;
                }
                else if(g==1){
                    if(s.charAt(i)==s.charAt(j)){
                        dp[i][j]=true;
                    }
                }
                else{
                    if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j]=true;
                    }
                }
                if(dp[i][j] && g+1>ans){
                    ans=g+1;
                    start=i;
                    end=j;
                }
            }
        }
        return s.substring(start,end+1);
    }
}