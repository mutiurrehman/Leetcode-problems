class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] arr = new int[n+1];
        for(int i=0;i<n;i++)
            arr[i]=heights[i];
        
        arr[n]=0;
        int[] nsr = new int[n+1];
        Stack<Integer> st = new Stack<>();
        for(int i=n;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty())
                nsr[i]=-1;
            else
                nsr[i]=st.peek();
            
            st.push(i);
            
        }
        int[] nsl = new int[n+1];
        st = new Stack<>();
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i])
                st.pop();
            if(st.isEmpty())
                nsl[i]=-1;
            else
                nsl[i]=st.peek();
            
            st.push(i);
            
        }
        int ans=0;
        for(int i=0;i<=n;i++)
            ans=Math.max(ans,(nsr[i]-nsl[i]-1)*arr[i]);
        return ans;
    }
    
}