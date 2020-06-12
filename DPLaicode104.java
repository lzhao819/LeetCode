//Laicode104 Longest Cross Of 1s
// Given a matrix that contains only 1s and 0s, find the largest cross which contains only 1s, with the same arm lengths and the four arms joining at the central point.

// Return the arm length of the largest cross.

// Assumptions

// The given matrix is not null, has size of N * M, N >= 0 and M >= 0.
// Examples

// { {0, 0, 0, 0},

//   {1, 1, 1, 1},

//   {0, 1, 1, 1},

//   {1, 0, 1, 1} }

// the largest cross of 1s has arm length 2.
public class Solution {
  public int largest(int[][] matrix) {
    if(matrix==null || matrix.length==0) return 0;
    int row= matrix.length;
    int col = matrix[0].length;
    if(col==0) return 0;
    int[][] ML = new int[row][col];
    int[][] MR = new int[row][col];
    int[][] MT = new int[row][col];
    int[][] MB = new int[row][col];
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        //left to right
        if(j==0 ||matrix[i][j-1]==0||matrix[i][j]==0){
          ML[i][j]=matrix[i][j];
        }else{
          ML[i][j]=ML[i][j-1]+1;
        }
        //top to bottom
        if(i==0 || matrix[i-1][j]==0||matrix[i][j]==0){
          MT[i][j]=matrix[i][j];
        }else{
          MT[i][j]=MT[i-1][j]+1;
        }
      }
    }//ML MT
    for(int i=row-1; i>=0;i--){
      for(int j=col-1; j>=0;j--){
        //left to right
        if(j==col-1 ||matrix[i][j+1]==0||matrix[i][j]==0){
          MR[i][j]=matrix[i][j];
        }else{
          MR[i][j]=MR[i][j+1]+1;
        }
        //bottom to top
        if(i==row-1 || matrix[i+1][j]==0||matrix[i][j]==0){
          MB[i][j]=matrix[i][j];
        }else{
          MB[i][j]=MB[i+1][j]+1;
        }
      }
    }//MR MB
    //find max cross
    int maxResult=0;
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        int cur=0;
        cur = Math.min(ML[i][j],MT[i][j]);
        cur = Math.min(cur,MR[i][j]);
        cur = Math.min(cur,MB[i][j]);
        maxResult = Math.max(cur,maxResult);
      }
    }
    return maxResult;
  }
}
