
import java.util.ArrayDeque;
import java.util.Queue;

public class robotMove {
    class dfsSolution{
        /**
         * Time O(m*n)
         * Space O(m*n)
         */
        public int movingCount(int m, int n, int k) {
            boolean[][] visited = new boolean[m][n];
            int[] result = new int[1];
            dfs(result, visited, k, 0, 0, m, n);
            return result[0];
        }
        private void dfs(int[] result, boolean[][] visited, int k, int row, int col, int m, int n){
            if(row<0||row>=m||col<0||col>=n||visited[row][col]||calSum(row, col)>k){
                return;
            }
            visited[row][col] = true;
            result[0]++;
            //吃了吐不吐需要看单元格是否可以多次访问，这道题每个单元格只能访问一次（因为是计数），就不用回溯不用吐
            //只需要 往下，右两个方向走，其他方向都计算过了
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

    class bfsSolution{
        /**
         * add (0,0) into queue
         * ternimation conditon: when queue is empty
         * Time O(m*n)
         * Space O(m*n)
         * DFS has better performance in this prob
         */
        public int movingCount(int m, int n, int k) {
            int result =0;
            boolean[][] visited = new boolean[m][n];
            Queue<int[]> queue = new ArrayDeque<>();
            queue.add(new int[]{0,0});
            while(!queue.isEmpty()){
                int[] x = queue.poll();
                int row=x[0], col=x[1];
                if(row<0||row>=m||col<0||col>=n||visited[row][col]||calSum(row, col)>k){
                    continue;
                }
                visited[row][col]=true;
                result++;
                queue.add(new int[]{row+1, col});
                queue.add(new int[]{row, col+1});
            }
            return result;
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
    
}


