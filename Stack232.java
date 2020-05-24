//232 Implement Queue using Stacks
//  Enqueue O(1)
//  Dequeue worse case O(n), Amortized O(1)

class MyQueue {
    public Deque<Integer> in;
    public Deque<Integer> out;
    
    /** Initialize your data structure here. */
    public MyQueue() {
        in = new LinkedList<>();
        out = new LinkedList<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        in.offerFirst(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        move();
        return out.pollFirst(); 
    }
    
    /** Get the front element. */
    public int peek() {
        move();
        return out.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        if(in.isEmpty() && out.isEmpty()) return true;
        return false;
    }
    
    //while out is empty, move all the elements in in to out
    private void move(){
        if(out.isEmpty()){
            while(!in.isEmpty()){
                out.offerFirst(in.pollFirst());
            }
        }  
    }//
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */