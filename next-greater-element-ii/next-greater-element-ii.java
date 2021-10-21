class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        int[] ans = new int[2*nums.length];
        
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[2*nums.length];
        for(int i=0;i<arr.length;i++){
            arr[i] = nums[i%nums.length];
        }
        for(int i=arr.length-1;i>=0;i--){
            
            while(!st.isEmpty() && st.peek()<=arr[i])
                st.pop();
            if(!st.isEmpty()){
                ans[i] = st.peek();
            }
            else{
                ans[i] = -1;
            }
            
            st.push(arr[i]);
            
        }
        
        int[] res = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            res[i] = ans[i];
        }
        
        return res;
    }
}