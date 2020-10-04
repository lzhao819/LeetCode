//Laicode89 Array Hopper II
// Given an array A of non-negative integers, you are initially positioned at index 0 of the array. A[i] means the maximum jump distance from index i (you can only jump towards the end of the array). Determine the minimum number of jumps you need to reach the end of array. If you can not reach the end of the array, return -1.

// Assumptions

// The given array is not null and has length of at least 1.
// Examples

// {3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)

// {2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
public class Solution {
  //method 1: left to right
  public int minJump(int[] array) {
    int[] M = new int[array.length];
    //donot need to jump for index0
    M[0] = 0;
    for(int i=1;i<array.length;i++){
      M[i]=-1;//initilize as non reachable
      for(int j=i-1;j>=0;j--){
        if(j+array[j]>=i && M[j] != -1){
          if(M[i]==-1 || M[i]>M[j]+1){
            M[i] = M[j]+1;
          }
        }
      }
    }//for
    return M[array.length-1];
  }

//Method2: right to left
  public int minJump(int[] array){
  int[] M = new int[array.length];
  M[array.length-1] = 0;
  M[0]=-1;
  for(int i=array.length-2; i>=0;i--){
    M[i]=-1;
    if(i+array[i]>= array.length-1){
      //if can reach end
      M[i]=1;
    }else{
     //if cannot reach end
     int curMin = Integer.MAX_VALUE;
     for(int j = array[i]; j>=1;j--){
       if(M[i+j]>0){
         curMin = Math.min(curMin, M[i+j]);
       }
     }
     if(curMin<Integer.MAX_VALUE){
       M[i]=curMin+1;
     }
    }
  }
  return M[0];
}
}