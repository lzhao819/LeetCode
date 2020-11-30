//Laicode106 Largest SubMatrix Sum
/** Given a matrix that contains integers, find the submatrix with the largest sum.

// Return the sum of the submatrix.

// Assumptions

// The given matrix is not null and has size of M * N, where M >= 1 and N >= 1
// Examples

// { {1, -2, -1, 4},

//   {1, -1,  1, 1},

//   {0, -1, -1, 1},

//   {0,  0,  1, 1} }

// the largest submatrix sum is (-1) + 4 + 1 + 1 + (-1) + 1 + 1 + 1 = 7.
 **/
public class Solution {
  public int largestI(int[][] matrix) {
    if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
    int row=matrix.length;
    int col=matrix[0].length;
    int result=Integer.MIN_VALUE;
    for(int i=0;i<row;i++){
      int[] cur = new int[col];
      for(int j=i;j<row;j++){
        //for each row i, we add rows one by one for row j
        //to make sure each time we only introduce O(n)
        add(cur, matrix[j]);
        //for each possible pair of row i,j,
        //we would like to know what is the largest submatrix sum
        //using top row as i and bottom as j
        //we flattern these area to a one demensional array
        result = Math.max(result,max(cur));
      }
    }//
    return result;
  }
  private void add(int[] cur, int[] add){
    for(int i=0;i<cur.length;i++){
      cur[i]+=add[i];
    }
  }//
  private int max(int[] cur){
    int result = cur[0];
    int tmp=cur[0];
    for(int i=1;i<cur.length;i++){
      tmp = Math.max(tmp+cur[i],cur[i]);
      result = Math.max(result,tmp);
    }
    return result;
  }//
}
