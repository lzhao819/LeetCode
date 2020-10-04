//641 Design Circular Deque

//using three stacks to implement deque: see moveHalf function, this improve the time complexity for remove

//using two stacks: move function instead of moveHalf

class MyCircularDeque {
    public Deque<Integer> s1;
    public Deque<Integer> s2;
    public int size;

    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        s1= new LinkedList<>();
        s2= new LinkedList<>();
        size = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if((s1.size() + s2.size()) == size){
            return false;
        }
        s1.offerFirst(value);
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if((s1.size() + s2.size()) == size){
            return false;
        }
        s2.offerFirst(value);
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if(s1.isEmpty()){
            moveHalf(s2,s1);
        }
        if(s1.isEmpty()) return false;
        s1.pollFirst();  
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if(s2.isEmpty()){
            moveHalf(s1,s2);
        }
        if(s2.isEmpty()) return false;
        s2.pollFirst();  
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if(s1.isEmpty()){
            moveHalf(s2,s1);
        }
        return s1.isEmpty()? -1 : s1.peekFirst();
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        if(s2.isEmpty()){
            moveHalf(s1,s2);
        }
        return s2.isEmpty()? -1 : s2.peekFirst(); 
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return s1.isEmpty() && s2.isEmpty();
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
       return (s1.size() + s2.size() == size) ?   true : false;
    }

    private void moveHalf(Deque<Integer> src, Deque<Integer> dest){
        Deque<Integer> buffer = new LinkedList<>();
        int size = src.size()/2;
        while(size--!=0){
            buffer.offerFirst(src.pollFirst());
        }
        while(!src.isEmpty()){
            dest.offerFirst(src.pollFirst());
        }
        while(!buffer.isEmpty()){
            src.offerFirst(buffer.pollFirst()); 
        }
    }

    private void move(Deque<Integer> src, Deque<Integer> dest){
        while(!src.isEmpty()){
            dest.offerFirst(src.pollFirst());
        }
    }
}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */