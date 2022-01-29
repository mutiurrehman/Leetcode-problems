class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] a = new int[n+1];
        for(int i=0;i<n;i++){
            a[i] = heights[i]; 
        }
        a[n] = 0;
        
        int[] nsr = new int[n+1];
        Stack<Integer> st = new Stack<>();
        for(int i=n;i>=0;i--){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            
            if(!st.isEmpty()){
                nsr[i] = st.peek();
            }
            else{
                nsr[i] = -1;
            }
            
            st.push(i);
        }
        
        int[] nsl = new int[n+1];
        st = new Stack<>();
        for(int i=0;i<=n;i++){
            while(!st.isEmpty() && a[st.peek()]>=a[i]){
                st.pop();
            }
            
            if(!st.isEmpty()){
                nsl[i] = st.peek();
            }
            else{
                nsl[i] = -1;
            }
            
            st.push(i);
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<=n;i++){
            max=Math.max(max, (nsr[i]-nsl[i]-1)*a[i]);
        }
        return max;
    }
}