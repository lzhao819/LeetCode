//27. Kth Smallest Sum In Two Sorted Arrays
// Given two sorted arrays A and B, of sizes m and n respectively. Define s = a + b, where a is one element from A and b is one element from B. Find the Kth smallest s out of all possible s'.

// Assumptions

// A is not null and A is not of zero length, so as B
// K > 0 and K <= m * n
// Examples

// A = {1, 3, 5}, B = {4, 8}

// 1st smallest s is 1 + 4 = 5
// 2nd smallest s is 3 + 4 = 7
// 3rd, 4th smallest s are 9 (1 + 8, 4 + 5) 
// 5th smallest s is 3 + 8 = 11
public class Solution {
  //Time O(k*logk)?
  //Space O(m*n +k) = O(m*n)_
  class Cell{
    int row;
    int col;
    int value;
    Cell(int row, int col, int value){
      this.row = row;
      this.col=col;
      this.value=value;
    }
  }
  public int kthSum(int[] A, int[] B, int k) {
    if(A==null || B==null || A.length==0 || B.length==0) return -1;
    if(A.length * B.length <k) return -1;
    int row = A.length;
    int col = B.length;
    PriorityQueue<Cell> minHeap = new PriorityQueue<>(k, new Comparator<Cell>(){
      @Override
      public int compare(Cell c1, Cell c2){
        if(c1.value==c2.value) return 0;
        return c1.value<c2.value? -1:1;
      }
    });

    boolean[][] visited = new boolean[row][col];
    visited[0][0]=true;
    minHeap.offer(new Cell(0,0,A[0]+B[0]));
    for(int i=0;i<k-1;i++){
      Cell cur = minHeap.poll();
      if(cur.row +1 <row && !visited[cur.row+1][cur.col]){
        minHeap.offer(new Cell(cur.row+1, cur.col, A[cur.row+1]+B[cur.col]));
        visited[cur.row+1][cur.col]=true;
      }
      if(cur.col +1 <col && !visited[cur.row][cur.col+1]){
        minHeap.offer(new Cell(cur.row, cur.col+1, A[cur.row]+B[cur.col+1]));
        visited[cur.row][cur.col+1]=true;
      }
    }

    return minHeap.peek().value;
  }
}
