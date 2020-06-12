//Laicode637 Largest Square Surrounded By One
// Determine the largest square surrounded by 1s in a binary matrix (a binary matrix only contains 0 and 1), return the length of the largest square.



// Assumptions

// The given matrix is guaranteed to be of size M * N, where M, N >= 0



// Examples

// {{1, 0, 1, 1, 1},

//  {1, 1, 1, 1, 1},

//  {1, 1, 0, 1, 0},

//  {1, 1, 1, 1, 1},

//  {1, 1, 1, 0, 0}}



// The largest square surrounded by 1s has length of 3.

public class Solution {
  public int largestSquareSurroundedByOne(int[][] matrix) {
    if(matrix==null||matrix.length==0||matrix[0].length==0) return 0;
    int row=matrix.length;
    int col = matrix[0].length;
    int result=0;
    int[][] MR= new int[row][col];
    int[][] MB= new int[row][col];
    //1111
    //1111
    //1111
    //1111
    for(int i=row-1; i>=0; i--){
      for(int j=col-1; j>=0;j--){
        //MR right to left
        if(j==col-1||matrix[i][j+1]==0||matrix[i][j]==0){
          MR[i][j]=matrix[i][j];
        }else{
          MR[i][j]=MR[i][j+1]+1;
        }
        //MB bottom to top
        if(i==row-1||matrix[i+1][j]==0||matrix[i][j]==0){
          MB[i][j]=matrix[i][j];
        }else{
          MB[i][j]=MB[i+1][j]+1;
        }
      }
    }//
    
    for(int i=0;i<row;i++){
      for(int j=0;j<col;j++){
        //check all the possible length from min(MR[i][j],MB[i][j]) to 1
        int n=Math.min(MR[i][j],MB[i][j]);
        for(int q=n;q>=1;q--){
          //check if top right corner with direction MB >=length
          //check if bottom left corner with direction MR >=length
          if(MB[i][j+q-1]>=q && MR[i+q-1][j]>=q){
            result=Math.max(q,result);
            break;
          }
        }
      }
    }//
    return result;
  }
}
