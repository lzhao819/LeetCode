//Time O(L^3MN)
//Space O(L)
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if (backtrack(board, i, j, word, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean backtrack(char[][]board, int row, int col, String word, int index){
        //check if we reach the bottom case of the recursion
        if(index==word.length()){
            return true;
        }
        //check if the current state is invalid-->bountries
        if(row<0 || row==board.length || col<0 || col==board[0].length || board[row][col]!=word.charAt(index)){
            return false;
        }
        //explore neighbors
        //mark the current cell as visited
        board[row][col] = '#';
        boolean result = backtrack(board, row-1, col, word, index+1) ||
                backtrack(board, row+1, col, word, index+1) ||
                backtrack(board, row, col-1, word, index+1) ||
                backtrack(board, row, col+1, word, index+1);
        //revert
        board[row][col] = word.charAt(index);
        return result;
    }
}
