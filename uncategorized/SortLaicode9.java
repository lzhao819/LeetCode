//Laicode9 Merge Sort
//ascending order
public class Solution {
  public int[] mergeSort(int[] array) {
    if(array==null||array.length<=1){
      return array;
    }
    //use a helper array to gurentee no more than O(n) space is used
    int[] helper = new int[array.length];
    mergeSort(array, helper, 0, array.length-1);
    return array;
  }

  private void mergeSort(int[] array, int[] helper, int left, int right){
    if(left>=right) return;
    
    int mid = left + (right-left)/2;
    mergeSort(array, helper, left, mid);
    mergeSort(array, helper, mid+1, right);
    merge(array, helper, left, mid, right);
  }// mergeSort

  private void merge (int[] array, int[] helper, int left, int mid, int right){
    //copy the content to helper array
    //merge from helper array
    for(int i =left;i<=right;i++){
      helper[i] = array[i];
    }
    int leftIndex = left;
    int rightIndex = mid+1;
    while(leftIndex <= mid && rightIndex<=right){
      if(helper[leftIndex]<=helper[rightIndex]){
        array[left++]=helper[leftIndex++];
      }else{
        array[left++]=helper[rightIndex++];
      }
    }
    //if we have left/ right elements left, we need to copy them
    while(leftIndex<=mid){
      array[left++]=helper[leftIndex++];
    }
    //because the right elements are already saved in the right
    // we do not need to copy them
  }//merge
}
