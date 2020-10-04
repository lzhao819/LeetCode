//Laicode 10: Quick sort
public class Solution {
  //Random rand = new Random();
  public int[] quickSort(int[] array) {
    if(array==null) return array;
    quickSort(array, 0, array.length-1);
    return array; 
  } 
  private void quickSort(int[] array, int left, int right){
    if(left>=right) return;
    //define a pivot and use the pivot to partition the array
    int pivotPos = partition(array, left, right);
    //pivot is already in its position 
    //so when recursively call the two partitions, the pivot should not be included
    quickSort(array, left, pivotPos-1);
    quickSort(array, pivotPos+1, right);
  }

  private int partition(int[] array, int left, int right){
    int pivotIndex = pivotIndex(left, right);
    int pivot = array[pivotIndex];
    //swap pivot to the end(rightmost) position
    swap(array, pivotIndex, right);
    int leftBound = left;
    int rightBound = right-1;
    while(leftBound<=rightBound){
        if(array[leftBound]<pivot){
          leftBound++;
        }else if(array[rightBound]>=pivot){
          rightBound--;
        }else{
          swap(array, leftBound++, rightBound--);
        }
    }
    //swap the pivot back to its position
    swap(array, leftBound, right);
    return leftBound;
  }

  //random pick a index in range of [left, right]
  private int pivotIndex(int left, int right){
    return left + (int)(Math.random()*(right - left+1));
  }

  private void swap(int[] array, int a, int b){
    int temp=array[a];
    array[a]=array[b];
    array[b]=temp;
  }
}
