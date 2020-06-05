//54 Spiral Matrix (M * N)
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix.length==0) return result;
        int left = 0;
        int right = matrix[0].length-1;
        int up = 0;
        int down = matrix.length-1;

        while(left < right && up < down){
          for(int i=left; i<=right; i++){
            result.add(matrix[up][i]);
          }
          for(int i=up+1; i<=down-1; i++){
            result.add(matrix[i][right]);
          }
          for(int i=right; i>=left; i--){
            result.add(matrix[down][i]);
          }
          for(int i=down-1; i>=up+1; i--){
            result.add(matrix[i][left]);
          }
          left++;
          right--;
          up++;
          down--;
        }

        //base case: nothing left/ one row left/ one column left
        //1 nothing left
        if(left>right || up>down){
          return result;
        }
        //2 one col left
        if(left==right){
          for(int i=up;i<=down;i++){
            result.add(matrix[i][left]);
          }
        }else{
          //3 one row left
          for(int i=left; i<=right;i++){
            result.add(matrix[up][i]);
          }
        }
        return result;
    }
}