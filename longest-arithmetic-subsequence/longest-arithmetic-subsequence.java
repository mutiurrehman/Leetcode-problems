class Solution {
    public int longestArithSeqLength(int[] A) {
        int n = A.length,res=2;
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        for(int i=0;i<n;i++){
            dp[i]=new HashMap<Integer, Integer>();
            for(int j=0;j<i;j++){
                int diff = A[i]-A[j];
                if(dp[j].containsKey(diff)){
                    dp[i].put(diff,dp[j].get(diff)+1);
                }
                else
                    dp[i].put(diff,2);
                res = Math.max(res,dp[i].get(diff));
            }
        }
        return res;
    }
}