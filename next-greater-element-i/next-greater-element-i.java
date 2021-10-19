class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
     
        int n = nums1.length;
        int[] ans = new int[n];
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            map.put(nums2[i],i);
        }
        
        Stack<Integer> st = new Stack<>();
        int[] ngr = new int[nums2.length];
        for(int i=nums2.length-1;i>=0;i--){
            
            while(!st.isEmpty() && st.peek()<nums2[i])
                st.pop();
            
            if(st.isEmpty()){
                ngr[i] = -1;
            }
            else{
                ngr[i] = st.peek();
            }
            
            st.push(nums2[i]);
        }
        
        for(int i=0;i<n;i++){
            int index = map.get(nums1[i]);
            ans[i] = ngr[index];
        }
        
        return ans;
    }
}