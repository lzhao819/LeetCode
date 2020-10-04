//Laicode 197 ReOrder Array
//Hard
//Given an array of elements, reorder it as follow:

// { N1, N2, N3, …, N2k } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k }

// { N1, N2, N3, …, N2k+1 } → { N1, Nk+1, N2, Nk+2, N3, Nk+3, … , Nk, N2k, N2k+1 }

// Try to do it in place.
public class Solution {
  public int[] reorder(int[] array) {
    if(array==null) return array;
    //if odd, we ignore the last element
    if(array.length%2 ==0){
      reOrder(array, 0, array.length-1);
    }else{
      reOrder(array, 0, array.length-2);
    }
    return array;
  }
   private void reOrder(int[] array, int l, int r){
     int length = r-l+1;
     // if subarray has 2 or 0 elements, reture as base case
     if(length<=2) return;
     //calculate mid point
     int mid = l + length/2;
     int lmid = l + length/4;
     int rmid = l + length*3/4;
     reverse(array, lmid, mid-1);
     reverse(array, mid, rmid-1);
     reverse(array, lmid, rmid-1);
     //half of the left partition size lmid-left
     reOrder(array, l, l +(lmid-l)*2 -1);
     reOrder(array, l +(lmid-l)*2, r);
   }
   private void reverse(int[] array, int l, int r){
     while(l<r){
       int tmp = array[l];
       array[l] = array[r];
       array[r] = tmp;
       l++;
       r--;
     }
   }
}
