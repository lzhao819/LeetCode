//744. Find Smallest Letter Greater Than Target

class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int l=0, r=letters.length-1;
        while(l<r-1){
          int mid = l+(r-l)/2;
          if(letters[mid]<=target){
            l=mid;
          }else{
            r=mid;
          } 
        }
        if(letters[l]>target) return letters[l];
        if(letters[r]<=target) return letters[0];
        return letters[r];
    }
}