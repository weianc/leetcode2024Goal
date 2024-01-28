class MinStack {
    Stack<Integer> stk;
    Stack<Integer> min;

    public MinStack() {
        this.stk = new Stack();
        this.min = new Stack();
    }
    
    public void push(int val) {
        stk.push(val);
        if(min.empty()){
            min.push(val);
        }
        else {
            int peek = min.peek();
            if(val < peek){
                min.push(val);
            }
            else {
                min.push(peek);
            }
        }
    }
    
    public void pop() {
        if(!stk.empty()){
            stk.pop();
            min.pop();
        }
    }
    
    public int top() {
        return stk.peek();
    }
    
    public int getMin() {
        return min.peek();
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