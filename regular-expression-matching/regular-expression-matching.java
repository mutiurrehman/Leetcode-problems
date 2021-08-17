class Solution {
    public boolean isMatch(String s, String p) {
        
        boolean[][] dp = new boolean[p.length()+1][s.length()+1];
        
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[i].length;j++){
                if(i==0 && j==0){
                    dp[i][j]=true;
                }
                else if(i==0){
                    dp[i][j]=false;
                }
                else if(j==0){
                    if(p.charAt(i-1)=='*')
                        dp[i][j] = dp[i-2][j];
                }
                else {
                    char pc = p.charAt(i-1);
                    char sc = s.charAt(j-1);
                    
                    if(pc=='*'){
                        dp[i][j]=dp[i-2][j];
                        if(p.charAt(i-2)==sc|| p.charAt(i-2)=='.')
                        dp[i][j]|=dp[i][j-1];
                    }
                    else if(pc==sc){
                        dp[i][j]=dp[i-1][j-1];
                    }
                    else if(pc=='.'){
                        dp[i][j]=dp[i-1][j-1];
                    }
                    else{
                        dp[i][j]=false;
                    }
                }
                
            }
        }
        return dp[p.length()][s.length()];
    }
}