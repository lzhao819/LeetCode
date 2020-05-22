//Laicode 17 Closest In Sorted Array
/*
Given a target integer T and an integer array A sorted in ascending order, find the index i in A such that A[i] is closest to T.

Assumptions

There can be duplicate elements in the array, and we can return any of the indices with same value.
Examples

A = {1, 2, 3}, T = 2, return 1
A = {1, 4, 6}, T = 3, return 1
A = {1, 4, 6}, T = 5, return 1 or 2
A = {1, 3, 3, 4}, T = 2, return 0 or 1 or 2
Corner Cases
What if A is null or A is of zero length? We should return -1 in this case.
*/
public class Solution {
  public int closest(int[] array, int target) {
    if(array==null||array.length==0){
      return -1;
    }
    int l=0,r=array.length-1;
    while(l<r-1){//when left neighbors right,stop
      int mid = l+(r-l)/2;
      if(array[mid]==target){
        return mid;
      }else if(array[mid]>target){
        r=mid;
      }else{
        l=mid;
      }
    }
    //post-processing to find cloest
    return Math.abs(array[l]-target) < Math.abs(array[r]-target)? l:r;
  }
}