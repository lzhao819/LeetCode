//Laicode97 Largest SubArray Sum
// Given an unsorted integer array, find the subarray that has the greatest sum. Return the sum.

// Assumptions

// The given array is not null and has length of at least 1.
// Examples

// {2, -1, 4, -2, 1}, the largest subarray sum is 2 + (-1) + 4 = 5

// {-2, -1, -3}, the largest subarray sum is -1
public class Solution {
  public int largestSum(int[] array) {
    int lastMax = array[0];
    int globalMax = array[0];
    for(int i=1;i<array.length;i++){
      lastMax = Math.max(array[i], lastMax+array[i]);
      globalMax = Math.max(globalMax, lastMax);
    }
    return globalMax;
  }
}