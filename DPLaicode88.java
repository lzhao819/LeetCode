//Laicode88 Array Hopper I
// Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from that position (you can only jump towards the end of the array). Determine if you are able to reach the last index.

// Assumptions

// The given array is not null and has length of at least 1.
// Examples

// {1, 3, 2, 0, 3}, we are able to reach the end of array(jump to index 1 then reach the end of the array)

// {2, 1, 1, 0, 2}, we are not able to reach the end of array
public class Solution {
  //Method1 DP(recommanded)
  public boolean canJump(int[] array) {
    if(array.length==1){
      return true;
    }
    boolean[] canJump=new boolean[array.length];
    for(int i=array.length-2;i>=0;i--){
      //if from index i, it is already possible to jump to the end
      if(i+array[i] >= array.length-1){
        canJump[i] = true;
      }else{
        //if ant of the reachabel indices from index i
        //is reachable to the end of the array
        for(int j=array[i];j>=1;j--){
          if(canJump[j+i]){
            canJump[i]=true;
            break;
          }
        }
      }
    }
    return  canJump[0];
  }
}
