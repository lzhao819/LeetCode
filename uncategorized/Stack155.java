//155 Min Stack

class MinStack {
    public Deque<Integer> stack;
    public Deque<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        minStack = new LinkedList<>();   
    }
    
    public void push(int x) {
        stack.offerFirst(x);
        if(minStack.isEmpty() || x<=minStack.peekFirst()){
            minStack.offerFirst(x);
        }     
    }
    
    public void pop() {
        //注意这里一定要用.equals()，不然对于null的情况会出错
        if(stack.peekFirst().equals(minStack.peekFirst())){
            minStack.pollFirst();
        }
        stack.pollFirst();   
    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return minStack.peekFirst();   
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