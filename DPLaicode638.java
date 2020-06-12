//Laicode638 Largest Square Of Matches
// Determine the largest square surrounded by a bunch of matches (each match is either horizontal or vertical), return the length of the largest square.

// The input is a matrix of points. Each point has one of the following values:

// 0 - there is no match to its right or bottom.

// 1 - there is a match to its right.

// 2 - there is a match to its bottom.

// 3 - there is a match to its right, and a match to its bottom.



// Assumptions

// The given matrix is guaranteed to be of size M * N, where M, N >= 0



// Examples

// {{3, 1, 1, 3, 0, 1, 1, 0},

//  {2, 0, 0, 2, 0, 0, 0, 0},

//  {3, 1, 3, 0, 0, 0, 0, 0},

//  {2, 0, 2, 0, 0, 0, 0, 0},

//  {1, 1, 0, 0, 0, 0, 0, 0}}



// This matrix represents the following bunch of matches:



// The largest square has length of 2.
public class Solution {
  public int largestSquareOfMatches(int[][] matrix) {
    if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
    int row=matrix.length;
    int col=matrix[0].length;
    int result=0;
    int[][] MR = new int[row+1][col+1];
    int[][] MB = new int[row+1][col+1];
    for(int i=row-1;i>=0;i--){
      for(int j=col-1;j>=0;j--){
        //right to left
        if(hasRight(matrix[i][j])){
          MR[i][j]=MR[i][j+1]+1;
        }
        //bottom to top
        if(hasBottom(matrix[i][j])){
          MB[i][j]=MB[i+1][j]+1;
        }
        if(hasBoth(matrix[i][j])){
          int n = Math.min(MR[i][j],MB[i][j]);
          for(int q=n;q>=1;q--){
            if(MR[i+q][j]>=q && MB[i][j+q]>=q){
              result=Math.max(q,result);
              break;
            }
          }
        }//end if
      }
    }//
    return result;
  }
  private boolean hasRight(int value){
    return (value &0b1) !=0;
  }
  private boolean hasBottom(int value){
    return (value &0b10) !=0;
  }
  private boolean hasBoth(int value){
    return value==3;
  }  
}
