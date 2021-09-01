class MinStack {

    /** initialize your data structure here. */
    
    Stack<Integer> st;
    Stack<Integer> min;
    public MinStack() {
        st = new Stack<>();
        min = new Stack<>();
    }
    
    public void push(int x) {
        
        if(!min.isEmpty()){
            if(x<=min.peek()){
                min.push(x);
            }
        }else{
            min.push(x);
        }
        
        st.push(x);
        
    }
    
    public void pop() {
        if(st.isEmpty())
            return;
        
        int rem = st.pop();
        if(rem == min.peek()){
            min.pop();
        }
    }
    
    public int top() {
        if(st.isEmpty())
            return -1;
        
        return st.peek();
        
    }
    
    public int getMin() {
        if(min.isEmpty())
            return -1;
        
        return min.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */