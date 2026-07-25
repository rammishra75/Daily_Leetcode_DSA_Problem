class MinStack {
    private Stack<Long> stk;
    private long mini;
    public MinStack() {
        stk = new Stack<>();
    }
    
    public void push(int val) {
        if(stk.isEmpty()){
            stk.push((long)val);
            mini = val;
            return;
        }
        else if(val < mini){
                long num = 2L * val - mini;
                stk.push(num);
                mini = val;
        }
        else{
            stk.push((long)val);
        }
    }
    
    public void pop() {
        long val = stk.pop();
        if(val < mini){
            mini = 2 * mini - val; 
        }
    }
    
    public int top() {
        if(stk.isEmpty()) return -1;
        long val = stk.peek();
        return val < mini ? (int) mini: (int) val;
       
    }
    
    public int getMin() {
        return (int)mini;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */