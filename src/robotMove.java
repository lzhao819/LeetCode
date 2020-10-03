package src;

public class robotMove {
    
}
class dfsSolution{
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int[] result = new int[1];
        dfs(result, visited, k, 0, 0, m, n);
        return result[0];
    }
    private void dfs(int[] result, boolean[][] visited, int k, int row, int col, int m, int n){
        if(row<0||row>=m||col<0||col>=n||visited[row][col]==true||calSum(row, col)>k){
            return;
        }
        visited[row][col] = true;
        result[0]++;
        //吃了吐不吐需要看单元格是否可以多次访问，这道题每个单元格只能访问一次（因为是计数），就不用回溯不用吐
        dfs(result, visited, k, row+1, col, m, n);
        dfs(result, visited, k, row, col+1, m, n);
    }
    private int calSum(int a, int b){
        int sum=0;
        while(a!=0){
            sum+= a%10;
            a /=10;
        }
        while(b!=0){
            sum+=b%10;
            b/=10;
        }
        return sum;
    }
}
