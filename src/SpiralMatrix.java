import java.util.ArrayList;
import java.util.List;

//LeetCode 54 Spiral Matrix

/**
 * 考虑设定矩阵的“左、上、右、下”四个边界，模拟以上矩阵遍历顺序。
 * Time O(MN)
 * Space O(1)
 */

class Solution {
  public List<Integer> spiralOrder(int[][] matrix) {
    if(matrix==null || matrix.length==0||matrix[0]==null) return new ArrayList<Integer>();
    List<Integer> result = new ArrayList<>();
    int l=0, r=matrix[0].length-1, t=0, b=matrix.length-1;
    while(true){
      for(int i=l;i<=r;i++){
        result.add(matrix[t][i]);//left to right
      }
      if(++t > b) break;
      for(int i=t;i<=b;i++){
        result.add(matrix[i][r]);//top to bottom
      }
      if(l > --r) break;
      for(int i=r;i>=l;i--){
        result.add(matrix[b][i]);//right to left
      }
      if(t > --b) break;
      for(int i=b;i>=t;i--){
        result.add(matrix[i][l]);//bottom to top
      }
      if(++l > r) break;
    }
    return result;
  }
}
