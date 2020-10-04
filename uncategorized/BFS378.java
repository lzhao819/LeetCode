//Leetcode
//Method1: heap
//1. Build a minHeap of elements from the first row.
//Do k-1 times :Every time when you poll out the root, replace that root with the next element from the same column.
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //assume: k<n*m and matrix is not null
        int row=matrix.length;
        int col=matrix[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2){
                if(c1.value==c2.value){
                    return 0;
                }
                return c1.value<c2.value?-1:1;
            }
        });
        
        for(int j = 0; j <= col-1; j++){
            minHeap.offer(new Cell(0, j, matrix[0][j])); 
        } 
        
        for(int i =0; i<k-1;i++){
            Cell cur= minHeap.poll();
            if(cur.row==row-1)continue;
            minHeap.offer(new Cell(cur.row+1, cur.column, matrix[cur.row+1][cur.column]));  
        }
        return minHeap.peek().value;   
    }
    
    class Cell{
        int row;
        int column;
        int value;
        Cell(int row, int column, int value){
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
}


//Method2: Binary Search
public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length - 1][matrix[0].length - 1] + 1;//[lo, hi)
        while(lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0,  j = matrix[0].length - 1;
            for(int i = 0; i < matrix.length; i++) {
                while(j >= 0 && matrix[i][j] > mid) j--;
                count += (j + 1);
            }
            if(count < k) lo = mid + 1;
            else hi = mid;
        }
        return lo;
    }
}

//Lai offer
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        //assume: k<n*m and matrix is not null
        int row=matrix.length;
        int col=matrix[0].length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k, new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2){
                if(c1.value==c2.value){
                    return 0;
                }
                return c1.value<c2.value?-1:1;
            }
        });
        
        boolean[][] visited= new boolean[row][col];
        minHeap.offer(new Cell(0,0,matrix[0][0]));
        visited[0][0]=true;
        for(int i =0; i<k-1;i++){
            Cell cur= minHeap.poll();
            //the neighbor will be insert back to heap if not out of boundary/not generated before
            if(cur.row+1<row && !visited[cur.row+1][cur.column]){
                minHeap.offer(new Cell(cur.row+1, cur.column, matrix[cur.row+1][cur.column]));
                visited[cur.row+1][cur.column]=true;
            }
            if(cur.column+1<col&&!visited[cur.row][cur.column+1]){
                minHeap.offer(new Cell(cur.row, cur.column+1, matrix[cur.row][cur.column+1]));
                visited[cur.row][cur.column+1]=true;
            }
        }
        return minHeap.peek().value;
        
    }
    
    class Cell{
        int row;
        int column;
        int value;
        Cell(int row, int column, int value){
            this.row = row;
            this.column = column;
            this.value = value;
        }
    }
}