package rotateImage;

/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3

 * anti-clockwise rotate
 * swap symmetry first and then do the reverse.
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
 */
//Time O(n)
public class Solution {
    //this code is for clockwise rotate
    public void rotate(int[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0){
            return;
        }
        reverse(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++)
                swap(matrix,i,j);
        }
    }

    private void reverse(int[][] matrix){
        int i=0;
        int j=matrix.length-1;
        while(i<j){
            int[] tmp = matrix[i];
            matrix[i]=matrix[j];
            matrix[j]=tmp;
            i++;
            j--;
        }
    }
    private void swap(int[][] matrix, int i, int j){
        int tmp = matrix[i][j];
        matrix[i][j] =  matrix[j][i];
        matrix[j][i] = tmp;
    }
}
