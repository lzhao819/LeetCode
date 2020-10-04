//74 Search in a 2D Matrix
//Integers in each row are sorted from left to right.
//The first integer of each row is greater than the last integer of the previous row.
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0 || matrix[0].length ==0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int l=0, r= row*col-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(target==matrix[mid/col][mid%col]){
                return true;   
            }else if(target>matrix[mid/col][mid%col]){
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return false;
        
    }
}