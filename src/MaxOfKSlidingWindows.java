//239. Sliding Window Maximum
// Given an integer array A and a sliding window of size K, find the maximum value of each window as it slides from left to right.

// Examples

// A = {1, 2, 3, 2, 4, 2, 1}, K = 3, the windows are {{1,2,3}, {2,3,2}, {3,2,4}, {2,4,2}, {4,2,1}},

// and the maximum values of each K-sized sliding window are [3, 3, 4, 4, 4]

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

//time O(n) - amortized for each step O(1), worse case O(k)
//Space O(n)
public class MaxOfKSlidingWindows {
    public static int[] maxWindows(int[] array, int k) {
      //using a deque to keep track of max value
      //the deque will be in descending order and the first element is the result
      //save int index rather than the real value in the deque
      //make sure deque only contains the index in current slidng window
      //for any index, the prev index with smaller value will be discard from deque
      int[] result = new int[array.length-k+1];
      Deque<Integer> deque = new ArrayDeque<>();
      //discard smaller value
      for(int i=0;i<array.length;i++){
        while(!deque.isEmpty() && array[deque.peekLast()]<=array[i]){
          deque.pollLast();
        }
        //discard the head value wich are out of the sliding window
        if(!deque.isEmpty() && deque.peekFirst()<=i-k){
          deque.pollFirst();
        }
        deque.offerLast(i);
        if(i>=k-1){
          result[i-k+1] = array[deque.peekFirst()];
        }
      }
      return result;
    }
    public static void main(String[] args) {
      System.out.println(Arrays.toString(maxWindows(new int[] {8, 2, 4}, 2)));
      System.out.println(Arrays.toString(maxWindows(new int[] {1,2,3,1,2}, 1)));
//      System.out.println(maxWindows( new int[] {1,1,1}, 1));
//      System.out.println(maxWindows(new int[] {2,5,4,6,8}, 4));
//      System.out.println(maxWindows( new int[] {2,4,3,7,8,6,5,16,19,33,32,34,35}, 5));
    }
  }
  