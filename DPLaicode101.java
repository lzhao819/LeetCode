//Laicode 101 Largest Square Of 1s
// Determine the largest square of 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.

// Assumptions

// The given matrix is not null and guaranteed to be of size N * N, N >= 0
// Examples

// { {0, 0, 0, 0},

//   {1, 1, 1, 1},

//   {0, 1, 1, 1},

//   {1, 0, 1, 1}}

// the largest square of 1s has length of 2
public class Solution {
  public int largest(int[][] matrix) {
    int N = matrix.length;
    if(N==0){
      return 0;
    }
    int result = 0;
    int[][] M = new int[N][N];
    for(int i=0;i<N;i++){
      for(int j=0;j<N;j++){
        if(i==0 || j==0){
          M[i][j] = (matrix[i][j]==1 ? 1:0);
        }else if(matrix[i][j]==1){
          M[i][j] = Math.min(M[i-1][j]+1, M[i][j-1]+1);
          M[i][j] = Math.min(M[i][j], M[i-1][j-1]+1);
        }
        result = Math.max(result, M[i][j]);
      }
    }
    return result;
  }
}
