class Solution {
    public int[] dailyTemperatures(int[] t) {
        
        Stack<Integer> st = new Stack<>();
        int n = t.length;
        int[] ngr = new int[n];
        
        for(int i=n-1;i>=0;i--){
            
            
            while(!st.isEmpty() && t[st.peek()] <= t[i])
                st.pop();
            
            if(!st.isEmpty())
                ngr[i] = st.peek();
            else
                ngr[i] = -1;
            
            st.push(i);
        }
        
        int[] ans = new int[n];
        
        for(int i =0;i<n;i++){
            if(ngr[i]!=-1)
            ans[i] = ngr[i]-i;
        }
        
        return ans;
    }
}