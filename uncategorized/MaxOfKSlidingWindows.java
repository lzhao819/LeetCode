// Given an integer array A and a sliding window of size K, find the maximum value of each window as it slides from left to right.

// Assumptions

// The given array is not null and is not empty

// K >= 1, K <= A.length

// Examples

// A = {1, 2, 3, 2, 4, 2, 1}, K = 3, the windows are {{1,2,3}, {2,3,2}, {3,2,4}, {2,4,2}, {4,2,1}},

// and the maximum values of each K-sized sliding window are [3, 3, 4, 4, 4]

//time O(n) - amortized for each step O(1), worse case O(k)
//Space O(n)
public class Solution {
    public List<Integer> maxWindows(int[] array, int k) {
      //using a deque to keep track of max value
      //the deque will be in decending order and the first element is the result
      //save int index rather than the real value in the deque
      //make sure deque only contains the index in current slidng window
      //for any index, the prev index with smaller value will be discard from deque
      List<Integer> result = new ArrayList<>();
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
          result.add(array[deque.peekFirst()]);
        }
      }
      return result;
    }
  }
  