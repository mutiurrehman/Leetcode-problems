class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        int[] ngr = new int[n];
        int[] ans = new int[n-k+1];
        Stack<Integer> st = new Stack<>();
        
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i])
                st.pop();
            if(st.isEmpty())
                ngr[i]=n;
            else
                ngr[i]=st.peek();
            
            st.push(i);
        }
        
        int j=0;
        for(int i=0;i<=n-k;i++){
            if(j<i)
                j=i;
            while(ngr[j]<i+k)
                j=ngr[j];
            
            ans[i]=nums[j];
        }
        
        return ans;
    }
}