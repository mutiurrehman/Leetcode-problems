class Solution {
    public int longestPalindromeSubseq(String text1) {
        
        
        String text2="";
        for(int i=text1.length()-1;i>=0;i--)
            text2=text2+text1.charAt(i);
        
      int m=text1.length(),n=text2.length();
        int [][]dp=new int[m+1][n+1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(i==0||j==0)
                dp[i][j]=0;
            }
        }
        
  
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[i].length;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1))
                    dp[i][j]=1+dp[i-1][j-1];
                else
                     dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                    
                
            }
        }
        return dp[m][n];  
    }
}