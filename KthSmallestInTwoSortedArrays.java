// Given two sorted arrays of integers, find the Kth smallest number.

// Assumptions

// The two given arrays are not null and at least one of them is not empty

// K >= 1, K <= total lengths of the two sorted arrays

// Examples

// A = {1, 4, 6}, B = {2, 3}, the 3rd smallest number is 3.

// A = {1, 2, 3, 4}, B = {}, the 2nd smallest number is 2.

//same with https://leetcode.com/problems/median-of-two-sorted-arrays/
//Time O(logk)
//Space O(1)
public class Solution {
    public int kth(int[] a, int[] b, int k) {
      return helper(a,0,b,0,k);
    }
    private int helper(int[] a, int aLeft, int[] b, int bLeft, int k){
      //base case
      if(aLeft>=a.length){
        return b[bLeft+k-1];
      }
      if(bLeft>=b.length){
        return a[aLeft+k-1];
      }
      if(k==1){
        return Math.min(a[aLeft],b[bLeft]);
      }
  
      //compare and delete 前2/k
      int amid = aLeft + k/2 - 1;
      int bmid = bLeft + k/2 - 1;
      //if a size is too small, remove from b first
      int aval = amid>=a.length? Integer.MAX_VALUE : a[amid];
      int bval = bmid>=b.length? Integer.MAX_VALUE : b[bmid];
  
      if(aval <= bval){
        return helper(a, amid+1, b, bLeft, k-k/2);
      }else{
        return helper(a, aLeft, b, bmid+1, k-k/2);
      }
    }
  }
  