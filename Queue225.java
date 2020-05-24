//225. Implement Stack using Queues (one queue or two queues)

//Using one Queue
class MyStack {
    public Queue<Integer> q;

    /** Initialize your data structure here. */
    public MyStack() {
        q = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q.offer(x);
        int n = q.size();
        while(n-->1){
            q.offer(q.poll());
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q.poll();  
    }
    
    /** Get the top element. */
    public int top() {
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(q.isEmpty()) return true;
        return false;    
    }
}


//Using Two Queues
class MyStack {
    
    public Queue<Integer> in;
    public Queue<Integer> out;

    /** Initialize your data structure here. */
    public MyStack() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(out.isEmpty()){
            out.offer(x);
        }else{
            while(!out.isEmpty()){
                in.offer(out.poll());
            }
            out.offer(x);
            while(!in.isEmpty()){
                out.offer(in.poll());
            }
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return out.poll();  
    }
    
    /** Get the top element. */
    public int top() {
        return out.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        if(out.isEmpty() && in.isEmpty()) return true;
        return false;    
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */