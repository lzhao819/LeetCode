import java.util.ArrayDeque;
import java.util.Deque;

public class MaxQueue {
    Deque<Integer> queue;
    Deque<Integer> maxqueue;

    public MaxQueue() {
        queue = new ArrayDeque<>();
        maxqueue = new ArrayDeque<>();
    }

    public int max_value() {
        if(queue.isEmpty()){
            return -1;
        }
        return maxqueue.peekFirst();
    }

    public void push_back(int value) {
        queue.offerLast(value);
        //递减
        while(!maxqueue.isEmpty() && value>maxqueue.peekLast()){
            maxqueue.pollLast();
        }
        maxqueue.offerLast(value);
    }

    public int pop_front() {
        if(queue.isEmpty()){
            return -1;
        }
        int value = queue.pollFirst();
        if(value==maxqueue.peekFirst()){
            maxqueue.pollFirst();
        }
        return value;
    }

}
