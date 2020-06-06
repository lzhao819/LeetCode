//Laicode87 Max Product Of Cutting Rope
// Given a rope with positive integer-length n, how to cut the rope into m integer-length parts with length p[0], p[1], ...,p[m-1], in order to get the maximal product of p[0]*p[1]* ... *p[m-1]? m is determined by you and must be greater than 0 (at least one cut must be made). Return the max product you can have.

// Assumptions

// n >= 2
// Examples

// n = 12, the max product is 3 * 3 * 3 * 3 = 81(cut the rope into 4 pieces with length of each is 3).
public class Solution {
  //Method1 左大段 + 右小段(reconmmanded)
  public int maxProduct(int length) {
    //assume length>2
    //index of M represent the length og the rope, M[i] represent the max product 
    int[] M=new int[length+1];
    M[1]=0;
    for(int i=2;i<=length;i++){
      //pick right most partition
      for(int j=1;j<i;j++){
        //for the left partition, we can choose not cut it or cut it
        //so the max number we can get is either j or M[j]
       M[i] = Math.max(M[i],Math.max(j, M[j])*(i-j));
      }
    }
    return M[length];
  }
}
