//Selection sort
public class Solution {
  public int[] solve(int[] array) {
    if(array==null||array.length<=1) return array;
    for(int i=0;i<array.length-1;i++){
      int min=i;
      for(int j=i;j<array.length;j++){
        if(array[min]>array[j]){
          min=j;
        }
      }
      swap(array,i,min);
    }
    return array;
  }
  private void swap(int[] array, int a, int b){
    int temp=array[a];
    array[a]=array[b];
    array[b]=temp;
  }
}
