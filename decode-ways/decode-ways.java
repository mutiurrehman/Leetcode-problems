class Solution {
    public int numDecodings(String A) {
        
        int[] dp = new int[A.length()];
        if(A.charAt(0)=='0')
            dp[0]=0;
        else
            dp[0]=1;
        
        for(int i=1;i<dp.length;i++){
            if(A.charAt(i-1)=='0' && A.charAt(i)=='0'){
                dp[i]=0;
            }
            else if(A.charAt(i-1)=='0' && A.charAt(i)!='0'){
                dp[i]=dp[i-1];
            }
            else if(A.charAt(i-1)!='0' && A.charAt(i)=='0'){
                if(A.charAt(i-1)=='1' || A.charAt(i-1)=='2'){
                    dp[i]= (i>=2 ?dp[i-2]: 1);
                }
                else{
                    dp[i]=0;
                }
            }
            else{
                if(Integer.parseInt(A.substring(i-1,i+1))<=26){
                    dp[i]=(dp[i-1]+ (i>=2 ?dp[i-2]: 1));
                }
                else{
                    dp[i]=dp[i-1];
                }
                
            }
        }
        
        return dp[A.length()-1];
    }
}
