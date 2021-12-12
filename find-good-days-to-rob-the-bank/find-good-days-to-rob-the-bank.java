class Solution {
    public List<Integer> goodDaysToRobBank(int[] security, int time) {
        
        int n = security.length;
        int[] pre = new int[n];
        pre[0] = 1;
        int cnt =1;
        for(int i=1;i<n;i++){
            if(security[i]<=security[i-1])
                cnt++;
            else
                cnt=1;
            
            pre[i] = cnt;
        }
        
        int[] suff = new int[n];
        suff[n-1] = 1;
        cnt=1;
        for(int i=n-2;i>=0;i--){
            if(security[i]<=security[i+1])
                cnt++;
            else
                cnt=1;
            suff[i] = cnt;
        }
        
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(pre[i]-1>=time && suff[i]-1>=time)
                ans.add(i);
        }
        
        return ans;
    }
}