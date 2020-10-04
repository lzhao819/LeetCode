//702 Search In Unknown Sized Sorted Array
//same as Laicode 20
/*
*  interface Dictionary {
*    public Integer get(int index);
*  }
*/

// You do not need to implement the Dictionary interface.
// You can use it directly, the implementation is provided when testing your solution.
public class Solution {
  public int search(Dictionary dict, int target) {
    if(dict==null) return -1;
    int left=0, right=1;
    //find the right boundry of the dictionary
    while(dict.get(right)!=null && dict.get(right)<target){
      //move left to right
      //double the right
      left = right;
      right = right*2;
    }
    //classic binary search
    return binarySearch(dict, target, left, right);
  }
  private int binarySearch(Dictionary dict,int target, int l, int r){
    while(l<=r){
      int mid = l+(r-l)/2;
      if(dict.get(mid)==null || dict.get(mid)>target){
        r=mid-1;
      }else if(dict.get(mid)<target){
        l=mid+1;
      }else{
        return mid;
      }
    }
    return -1;
  }
}