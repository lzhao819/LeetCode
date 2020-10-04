//295. Find Median from Data Stream
//Same to Laicode 113 Median Tracker
//Hard
class MedianFinder {
    private PriorityQueue<Integer> largeHalf;//min heap
    private PriorityQueue<Integer> smallHalf;//max heap
    
    /** initialize your data structure here. */
    public MedianFinder() {
        //The Collections.reverseOrder() 
        //provides a Comparator that would sort the elements in the PriorityQueue 
        //in a the oposite order to their natural order in this case
        largeHalf = new PriorityQueue<>();//default PriorityQueue is a MIN HEAP
        smallHalf = new PriorityQueue<>(11, Collections.reverseOrder()); 
    }
    
    //small.size = large.size or large.size +1
    public void addNum(int num) {
        if(largeHalf.isEmpty() || num<=smallHalf.peek()){
          smallHalf.offer(num);
        }else{
          largeHalf.offer(num);
        }
        //after insert
        //keep balance of the size
        if(smallHalf.size()-largeHalf.size()>=2){
          largeHalf.offer(smallHalf.poll());
        }else if(smallHalf.size()<largeHalf.size()){
          smallHalf.offer(largeHalf.poll());
        }  
    }
    
    public double findMedian() {
        int size = size();
        if(size==0){
          return -1;
        }else if(size%2!=0){
          return (double)smallHalf.peek();
        }else{
          return (smallHalf.peek()+ largeHalf.peek())/2.0;
        }
    }

      private int size(){
        return smallHalf.size() + largeHalf.size();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */