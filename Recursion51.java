//51. N-Queens
public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<List<String>>();
        String[] board = new String[n];
        char[] initial = new char[n];
        Arrays.fill(initial, '.');
        Arrays.fill(board, String.valueOf(initial));
        boolean[] cols = new boolean[n], d1 = new boolean[2 * n], d2 = new boolean[2 * n];
        helper(res, board, cols, d1, d2, 0, n);
        return res;
    }
    public void helper(List<List<String>> res, String[] board, boolean[] cols, boolean[] d1, boolean[] d2, int row, int n){
        if(row == n){
            res.add(new ArrayList<String>(Arrays.asList(board)));
            return ;
        }
        
        for(int col = 0; col < n; col ++){
            if(cols[col] || d1[row + col] || d2[row - col + n]) continue;
            
            cols[col] = true; d1[row + col] = true; d2[row - col + n] = true;
            char[] cur = board[row].toCharArray();
            cur[col] = 'Q';
            board[row] = String.valueOf(cur);
            
            helper(res, board, cols, d1, d2, row + 1, n);
            
            cur = board[row].toCharArray();
            cur[col] = '.';
            board[row] = String.valueOf(cur);
            
            cols[col] = false; d1[row + col] = false; d2[row - col + n] = false;
        }
    }