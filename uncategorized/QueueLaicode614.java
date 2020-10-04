//Laicode614 Design Circular Queue
//https://app.laicode.io/app/problem/614
// Design your implementation of the circular queue. The circular queue is a linear data structure in which the operations are performed based on FIFO (First In First Out) principle and the last position is connected back to the first position to make a circle. It is also called "Ring Buffer".

// One of the benefits of the circular queue is that we can make use of the spaces in front of the queue. In a normal queue, once the queue becomes full, we cannot insert the next element even if there is a space in front of the queue. But using the circular queue, we can use the space to store new values.

// Your implementation should support following operations:

// MyCircularQueue(k): Constructor, set the size of the queue to be k.
// Front: Get the front item from the queue. If the queue is empty, return -1.
// Rear: Get the last item from the queue. If the queue is empty, return -1.
// enQueue(value): Insert an element into the circular queue. Return true if the operation is successful.
// deQueue(): Delete an element from the circular queue. Return true if the operation is successful.
// isEmpty(): Checks whether the circular queue is empty or not.
// isFull(): Checks whether the circular queue is full or not.
 

// Example:

// MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
// circularQueue.enQueue(1);  // return true
// circularQueue.enQueue(2);  // return true
// circularQueue.enQueue(3);  // return true
// circularQueue.enQueue(4);  // return false, the queue is full
// circularQueue.Rear();  // return 3
// circularQueue.isFull();  // return true
// circularQueue.deQueue();  // return true
// circularQueue.enQueue(4);  // return true
// circularQueue.Rear();  // return 4
 

// Note:

// All values will be in the range of [0, 1000].
// The number of operations will be in the range of [1, 1000].
// Please do not use the built-in Queue library.

//Using circular array
class MyCircularQueue {
      int[] queue;
      int head;
      int tail;
      int size;
   
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
      queue = new int[k+1];
      head=0;
      tail=1; 
      size=k;
    }
    //tail in, head out
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
      if(head==tail) return false;
      queue[tail]=value;
      tail = tail==size? 0:tail+1;
      return true;   
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
      if(isEmpty()) return false;
      head= head==size? 0:head+1;
      return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
      if(isEmpty()) return -1;
      return head==size? queue[0]:queue[head+1];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
      if(isEmpty()) return -1;
      return tail==0? queue[size]:queue[tail-1];   
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
      if((head+1) == tail){
        return true;
      } else if(head==size && tail==0){
        return true;
      }
      return false;   
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
      if(head==tail) return true;
      return false;  
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */