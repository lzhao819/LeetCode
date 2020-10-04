//Laicode108 Perfect Shuffle
// Given an array of integers (without any duplicates), shuffle the array such that all permutations are equally likely to be generated.

// Assumptions

// The given array is not null
public class Solution {
  public void shuffle(int[] array) {
    if(array==null||array.length<=1) return;
    //Random random = new Random();
    for(int i=array.length;i>=1;i--){
      int j=(int)(Math.random()*i);
      //int j=random.nextInt(i);
      swap(array, i-1, j);
    }
    return;
  }
  private void swap(int[] array, int a, int b){
    int tmp = array[a];
    array[a] = array[b];
    array[b] = tmp;
  }
}