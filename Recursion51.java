//51. N-Queens
//Laicode 233
//Return A list of ways of putting the N Queens
//Each way is represented by a list of the Queen's y index for x indices of 0 to (N - 1)
public class Solution {
  //Method1: valid the queen position in O(n) each time
  public List<List<Integer>> nqueensI(int n) {
    List<List<Integer>> result= new ArrayList<List<Integer>>();
    //cur will be a list of size n, and cur[i] is the column number
    //where the qween on row i is positioned
    List<Integer> cur = new ArrayList<>();
    helper(n,cur, result);
    return result;
  }
  private void helper(int n, List<Integer> cur, List<List<Integer>> result){
    //base case
    if(cur.size()==n){
      result.add(new ArrayList<Integer>(cur));
      return;
    } 
    for(int i=0;i<n;i++){
      //check if the position is valid
      if(valid(cur, i)){
        cur.add(i);
        helper(n, cur, result);
        cur.remove(cur.size()-1);
      }
    }
  }//
  private boolean valid(List<Integer> cur, int col){
    int row=cur.size();
    for(int i=0;i<row;i++){
      if(cur.get(i)== col || Math.abs(cur.get(i)-col)==row -i){
        return false;
      }
    }
    return true;
  }

  //Method2: valid the queen position in O(1) each time
  public List<List<Integer>> nqueensII(int n) {
    List<List<Integer>> result = new ArrayList<>();
    //cur will be a list of size n, and cur[i] is the column number
    //where the qween on row i is positioned
    int[] cur = new int[n];
    //record which column is already a queen
    boolean[] usedCol = new boolean[n];
    //record which diagnal line is already a queen
    boolean[] usedDia = new boolean[2*n -1];
    //record which reverse diagnal line is already a queen
    boolean[] usedRevDia = new boolean[2*n -1];
    helper(n, 0, cur, result, usedCol, usedDia, usedRevDia);
    return result;
    }//
    private void helper(int n, int row, int[] cur, List<List<Integer>> result, boolean[] usedCol, boolean[] usedDia, boolean[] usedRevDia){
      //base case
      if(row == n){
        result.add(toList(cur));
        return;
      }
      for(int i=0; i<n;i++){
        if(valid(n, row, i, usedCol, usedDia, usedRevDia)){
          mark(n, row, i, usedCol, usedDia, usedRevDia);
          cur[row]=i;
          helper(n, row+1, cur, result, usedCol, usedDia, usedRevDia);
          unmark(n, row, i, usedCol, usedDia, usedRevDia);
        }
      }
    }//
    private boolean valid(int n, int row, int col, boolean[] usedCol, boolean[] usedDia, boolean[] usedRevDia){
      return !usedCol[col] && !usedDia[col + row] && !usedRevDia[col-row +n -1];
    }//
    private void mark(int n, int row, int col, boolean[] usedCol, boolean[] usedDia, boolean[] usedRevDia){
      usedCol[col]=true;
      usedDia[col+row]=true;
      usedRevDia[col-row +n -1]=true;
    }//
    private void unmark(int n, int row, int col, boolean[] usedCol, boolean[] usedDia, boolean[] usedRevDia){
      usedCol[col]=false;
      usedDia[col+row]=false;
      usedRevDia[col-row +n -1]=false;
    }//
    private List<Integer> toList(int[] array){
      List<Integer> list = new ArrayList<>();
      for(int num : array){
        list.add(num);
      }
      return list;
    }//
}
