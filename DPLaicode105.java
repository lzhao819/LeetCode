//Laicode105 Largest X Of 1s
// Given a matrix that contains only 1s and 0s, find the largest X shape which contains only 1s, with the same arm lengths and the four arms joining at the central point.

// Return the arm length of the largest X shape.

// Assumptions

// The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
// Examples

// { {0, 0, 0, 0},

//   {1, 1, 1, 1},

//   {0, 1, 1, 1},

//   {1, 0, 1, 1} }

// the largest X of 1s has arm length 2.

public class Solution {
  public int largest(int[][] matrix) {
    if(matrix==null || matrix.length==0) return 0;
    if(matrix[0].length==0) return 0;
    int row = matrix.length;
    int col = matrix[0].length;
    int[][] M1 = new int[row][col];
    int[][] M2 = new int[row][col];
    int[][] M3 = new int[row][col];
    int[][] M4 = new int[row][col];
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        //top-left
        if(i==0||j==0||matrix[i-1][j-1]==0){
          M1[i][j]=matrix[i][j];
        }else{
          M1[i][j]=M1[i-1][j-1]+1;
        }
        //top-right
        if(i==0||j==col-1||matrix[i-1][j+1]==0){
          M2[i][j]=matrix[i][j];
        }else{
          M2[i][j]=M2[i-1][j+1]+1;
        }
      }
    }//
    for(int i=row-1;i>=0;i--){
      for(int j=col-1;j>=0;j--){
        //right-bottom
        if(j==col-1||i==row-1||matrix[i+1][j+1]==0){
          M4[i][j]=matrix[i][j];
        }else{
          M4[i][j]=M4[i+1][j+1]+1;
        }
        //left-bottom
        if(i==row-1||j==0||matrix[i+1][j-1]==0){
          M3[i][j]=matrix[i][j];
        }else{
          M3[i][j]=M3[i+1][j-1]+1;
        }
      }
    }//
    int result = 0;
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        int cur = Math.min(M1[i][j], M2[i][j]);
        cur = Math.min(cur, M3[i][j]);
        cur = Math.min(cur, M4[i][j]);
        result = Math.max(result, cur);
      }
    }
    return result;
  }
}
