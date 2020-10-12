// Given an integer array of length L, find the number that occurs more than 0.5 * L times.

// Assumptions

// The given array is not null or empty
// It is guaranteed there exists such a majority number
// Examples

// A = {1, 2, 1, 2, 1}, return 1
//time O(n)
//space O(1)
public class MajorityNumberI {
    public int majority(int[] array) {
      int major =array[0];
      int count =0;
      for(int i=0;i<array.length;i++){
        if(count==0){
          major = array[i];
        }
        if(array[i]==major){
          count++;
        }else{
          count--;
        }
      }
      return major;
    }
  }