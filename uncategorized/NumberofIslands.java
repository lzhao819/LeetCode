//Leetcode 200. Number of Islands
//time O(m*n)
//Space O(1)
class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        if(grid==null || grid.length<1 || grid[0]==null || grid[0].length<1) return result;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result; 
    }
    private void dfs(char[][] grid, int i, int j){
        if(i>=grid.length || i<0 || j>=grid[0].length || j<0 || grid[i][j]!='1') return;
        //mark the visited as '2' so that we can recover
        grid[i][j] ='2';
        dfs(grid, i-1, j);
        dfs(grid, i+1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}
