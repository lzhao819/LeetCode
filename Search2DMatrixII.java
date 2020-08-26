// 240. Search a 2D Matrix II
// Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

// Integers in each row are sorted in ascending from left to right.
// Integers in each column are sorted in ascending from top to bottom.
//Time O(m+n)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null || matrix.length < 1|| matrix[0]==null||matrix[0].length < 1) return false;
        int row = 0,
            col = matrix[0].length-1;
        while(col>=0 && row<matrix.length){
            if(target==matrix[row][col]){
                return true;
            }else if(target<matrix[row][col]){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}