//Laicode121 Spiral Order Traverse I
public class Solution {
  public List<Integer> spiral(int[][] matrix) {
    List<Integer> result = new ArrayList<>();
    recursive(matrix, 0, matrix.length, result);
    return result;
  }
  private void recursive(int[][] matrix, int offset, int size, List<Integer> result){
    //base case1:when there is only 0 left
    if(size==0) return;
    //base case1:when there is only 1 left
    if(size==1){
      result.add(matrix[offset][offset]);
      return;
    }
    for(int i=0;i<size-1;i++){
      result.add(matrix[offset][offset+i]);
    }
    for(int i=0;i<size-1;i++){
      result.add(matrix[offset+i][offset+size-1]);
    }
    for(int i=size-1;i>=1;i--){
      result.add(matrix[offset+size-1][offset+i]);
    }
    for(int i=size-1;i>=1;i--){
      result.add(matrix[offset+i][offset]);
    }
    recursive(matrix, offset+1, size-2, result);
  }
}
