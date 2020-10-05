//155 Min Stack

import java.util.ArrayDeque;
import java.util.Deque;
//Time O(1) for each operation
//Space O(N)
class MinStack {
    Deque<Integer> stack;
    Deque<Integer> min;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new ArrayDeque<>();
        min = new ArrayDeque<>();
    }

    public void push(int x) {
        if(stack.isEmpty() || x<=min.peek()){
            min.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        /**注意这里一定要用.equals()，不然对于null的情况会出错*/
        if(stack.peek().equals(min.peek())){
            min.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
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