//Laicode280 Sort With 2 Stacks
//Applecation of Selection Sort
//Given an array that is initially stored in one stack, sort it with one additional stacks (total 2 stacks).
//After sorting the original stack should contain the sorted integers and from top to bottom the integers are sorted in ascending order.
//Assumptions: The given stack is not null. There can be duplicated numbers in the give stack.
public class Solution {
  public void sort(LinkedList<Integer> s1) {
    //corner case
    if(s1==null || s1.size()<=1) return;
    LinkedList<Integer> s2 = new LinkedList<Integer>();
    sort2(s1,s2);
  }

  //method1: buffer(left | right) sorted | buffer
  private void sort1(Deque<Integer> input, Deque<Integer> buffer){
    //step1: sort in ascending order and store in the buffer
    while(!input.isEmpty()){
      int curMin = Integer.MAX_VALUE;
      int count = 1;
      while(!input.isEmpty()){
        int cur = input.pollFirst();
        if(cur < curMin){
          curMin = cur;
          count = 1;
        }else if(cur == curMin){
          count++;
        }
        buffer.offerFirst(cur);
      }
      while(!buffer.isEmpty() && buffer.peekFirst()>=curMin){
        int tmp = buffer.pollFirst();
        if(tmp != curMin){
          input.offerFirst(tmp);
        }
      }
      while(count-->0){
        buffer.offerFirst(curMin);
      }
    }
    //step2: move result from buffer to input, so its in descending order
    while(!buffer.isEmpty()){
      input.offerFirst(buffer.pollFirst());
    }
  }//sort1

  //method2: sort in descending order and store the result in the bottom of the input
  private void sort2(Deque<Integer> input, Deque<Integer> buffer){
    int prevMax = Integer.MAX_VALUE;
    while(input.peekFirst() < prevMax){
      int curMax = Integer.MIN_VALUE;
      int count = 0;
      while(!input.isEmpty() && input.peekFirst()<prevMax){
        int cur = input.pollFirst();
        if(cur>curMax){
          curMax = cur;
          count = 1;
        }else if(cur == curMax){
          count++;
        }
        buffer.offerFirst(cur);
      }
      while(count-->0){
        input.offerFirst(curMax);
      }
      while(!buffer.isEmpty()){
        int tmp = buffer.pollFirst();
        if(tmp!=curMax){
          input.offerFirst(tmp);
        }
      }
      prevMax = curMax;
    }
  }//sort2
}