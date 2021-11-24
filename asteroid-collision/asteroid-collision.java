class Solution {
    public int[] asteroidCollision(int[] as) {
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<as.length;i++){
            int curr = as[i];
            boolean push = true;
            while(!st.isEmpty() && st.peek()>0 && curr<0){
                int temp = Math.abs(curr);
                if(st.peek()>=temp){
                    push = false;
                    if(st.peek()==temp){
                        st.pop();
                    }
                    
                    break;
                } else{
                    st.pop();
                }   
            }
            
            if(push){
                st.push(curr);
            }
        }
       
         int[] result = new int[st.size()];
         for (int i = result.length - 1; i >= 0; --i)
              result[i] = st.pop();
    
        return result;
    }
}